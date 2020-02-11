package com.woniu.cache;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisCache implements Cache{
	
	private RedisTemplate<Object, Object> redisTemplate0;
	private RedisTemplate<Object, Object> redisTemplate1;
	private HotTable hotTable;
	private String id;
	
	public boolean isHotData() {
		
		
		for (String nameSpace : hotTable.getHotTable()) {
			if(id.equals(nameSpace)) {
				return true;
			}
		}
		
		return false;
	}
	
	public RedisCache(String id) {
		System.out.println("is is ===============>"+id);
		if(id==null)
			throw new RuntimeException("参数id不能为空 ");
		this.id = id;
		redisTemplate0 = (RedisTemplate<Object, Object>)AppliactonContextHolder.getBean("redisTemplate0");
		redisTemplate1 = (RedisTemplate<Object, Object>)AppliactonContextHolder.getBean("redisTemplate1");
		hotTable = (HotTable)AppliactonContextHolder.getBean("hotTable");
		System.out.println(hotTable.getHotTable());
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void putObject(Object key, Object value) {
		readWriteLock.writeLock().lock();
		
		// TODO Auto-generated method stub
		try {
			if(isHotData()) {
				this.redisTemplate1.opsForValue().set(key, value);
			}else {
				this.redisTemplate0.opsForValue().set(key, value);
				this.redisTemplate0.expire(key, new Random().nextInt(60), TimeUnit.MINUTES);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}finally {
			readWriteLock.writeLock().unlock();
		}
		
	}

	@Override
	public Object getObject(Object key) {
		
		readWriteLock.readLock().lock();
		try {
			// TODO Auto-generated method stub
			if(isHotData()) {
				Object obj = this.redisTemplate1.opsForValue().get(key);
				if(obj==null) {//应对缓存穿透
					this.redisTemplate1.opsForValue().set(key, null);
				}
				return obj;
			}else {
				Object obj = this.redisTemplate0.opsForValue().get(key);
				if(obj==null) {//应对缓存穿透
					this.redisTemplate0.opsForValue().set(key, null);
				}
				return obj;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}finally {
			readWriteLock.readLock().unlock();
		}
		return null;
	}

	@Override
	public Object removeObject(Object key) {
		// TODO Auto-generated method stub
		readWriteLock.writeLock().lock();
		try {
			if(isHotData())
				this.redisTemplate1.delete(key);
			else 
				this.redisTemplate0.delete(key);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}finally {
			readWriteLock.writeLock().unlock();
			return null;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		//以前的clear只刷新当前命名空间   现在的clear清空整个缓存
		//不准这么用  this.redisTemplate.getConnectionFactory().getConnection().flushDb();
		this.redisTemplate0.execute(new RedisCallback() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				// TODO Auto-generated method stub
				connection.flushDb();
				return null;
			}
			
		});
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		Object size = this.redisTemplate0.execute(new RedisCallback() {

			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				// TODO Auto-generated method stub
				return connection.dbSize();
			}
			
		});
		return Integer.parseInt(size.toString());
	}
	
	@Override
	public ReadWriteLock getReadWriteLock() {
		// TODO Auto-generated method stub
		return readWriteLock;
	}
	private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
}
