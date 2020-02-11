Redis几种数据类型
你是在那里用的Redis，怎么用的？
1：用Redis来记录短信验证码	
	写代码的流程上
2：用Redis来替换Mybatis的二级缓存，解决脏读，穿透，击穿，雪崩等问题。
	写代码的流程上
		具体如何解决上述问题。

3：用Redis来做秒杀中的库存。做秒杀中的订单。
	1：watch
	2: set 分布式锁
4：用Redis来做分布式中的session共享。

把核心比较背过。
==============================================================

Redis:
	Redis是单线程的。

Redis的秒杀：
	只考虑库存。

	1：库存====》存放在数据库中，每卖一个，从数据库中-1.数据库是一个典型的IO操作，耗时。

	2：把库存放在Redis中。提供程序运行的效率。

=============================================
	1：Redis中的库存的数量

		
	2：卖给用户的数量

========================================================
package com.woniu.controller;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyController {
	//库存以前放在数据库中，现在放在Redis中
	@Resource
	private RedisTemplate<String, Integer> redisTemplate;
	
	private AtomicInteger buyCount;
	
	//初始化工作   启动的时候读取数据库获取数据库的库存
	@GetMapping("init")
	public String init() {
		redisTemplate.opsForValue().set("count", 5);
		buyCount = new AtomicInteger(0);
		return "初始化完毕";
	}
	
	//Buy的行为，买的时候库存要-1,用户购买的数量+1
	@GetMapping("buy")
	public synchronized String buy() {
		int count = redisTemplate.opsForValue().get("count");
		count=count-1;
		if(count<0) {
			return "已经售罄，请明天再来";
		}
		redisTemplate.opsForValue().set("count",count);
		return "成功购买，购买了"+buyCount.incrementAndGet()+"件";
	}
	
	//查看用户现在买了几个
	@GetMapping("getCount")
	public String getCount() {
		return "总共购买了"+buyCount.get();
	}
}
========================================================
1：使用库存的类型是 int .
	buyCount++;
	
	i++:
			本身编译后就是3条指令。
				get
				+1
				set值

			就有指令重排的问题，CAS（比较并且交换）的问题，而且也没有保证原子性。

		高并发情况下，一定用AtomicInteger。

2: 把int buyCount换成
	private AtomicInteger buyCount;

	并且获取值的时候
	 "成功购买，购买了"+buyCount.incrementAndGet()+"件";

	但是结果依然超卖。原因是？
	这个方法不是原子性的。尽管redisTemplate和+buyCount现在均为原子性。

	public  String buy() {
		int count = redisTemplate.opsForValue().get("count");
		count=count-1;
		if(count<0) {
			return "已经售罄，请明天再来";
		}
		redisTemplate.opsForValue().set("count",count);
		return "成功购买，购买了"+buyCount.incrementAndGet()+"件";
	}

==============================================================
Redis的事务：


JDBC的事务：
	原子性 一致性  隔离性  持久性

	commit  rollback

Redis的事务比较简单，直接用就行了，也没有那摸多的性。
	也跟数据库的事务完全不一样。

	multi        exec            discard
	开启事务     执行事务        销毁事务
	
redis 127.0.0.1:6379> multi
OK
redis 127.0.0.1:6379> set a aaa
QUEUED
redis 127.0.0.1:6379> set b bbb
QUEUED
redis 127.0.0.1:6379> set c ccc
QUEUED
redis 127.0.0.1:6379> exec
1) OK
2) OK
3) OK


==========
redis 127.0.0.1:6379> multi
OK
redis 127.0.0.1:6379> set a aaa
QUEUED
redis 127.0.0.1:6379> incr a
QUEUED
redis 127.0.0.1:6379> set c ccc
QUEUED
redis 127.0.0.1:6379> exec
1) OK
2) (error) ERR value is not an integer or out of range
3) OK
redis 127.0.0.1:6379> get c
"ccc"

即便中间一句话执行出错了，也不会影响其他代码的执行，相当于只有原来数据库的事务中的 串行化。
唯一能保证的是：执行这几句话中不会有其他线程进来执行。串行化。
==============
redis 127.0.0.1:6379> multi
OK
redis 127.0.0.1:6379> set a aaa
QUEUED
redis 127.0.0.1:6379> set b bb
QUEUED
redis 127.0.0.1:6379> set c cc
QUEUED
redis 127.0.0.1:6379> discard
OK
redis 127.0.0.1:6379> get a
(nil)
redis 127.0.0.1:6379>
==============================================================
Redis的Watch(乐观锁 一般会要求有一种重试机制):
	和Java CAS比较接近。原理即便是一致的。

	watch 在事务开始之前，就观察一个元素。
		如果在事务前，有任何线程，甚至是自己这个线程 修改了这个元素的值。
		认为，当前数据是不应该被修改的，事务执行过程就是0.相当于不执行。

	
AS1：
	set age 1
	watch age
	multi
	set a aaa
		=================>此时另外一个线程 incr age
	set b bbb
	exec===>nil  

AS2：
	set age 1
	watch age
	incr age
	multi
	set a aaa
	set b bbb
	exec===>nil

AS3：
	set age 1
	watch age
	multi
	incr age
	exec===>2 ok


	public void buy() throws InterruptedException {
		Jedis jedis = new Jedis("127.0.0.1",6379);
		while (true) {
			System.out.println("执行一次");
			jedis.set("age","1");//set age 1
			jedis.watch("age");//watch age
			
			Thread.sleep(5000);
			
			Transaction tx= jedis.multi();//	multi
			tx.set("age", "2");//incr age
			List list = tx.exec();
			if(list!=null&&list.size()>0) {
				break;
			}
		}
		System.out.println(jedis.get("age"));
	}

==============================================================
Redids的分布式锁（悲观锁）：
	分布式锁的实现方式有好多种：
		数据库，静态变量，Redis。
	
原理：
	应该具有一把全局的公用的锁。
	早期的分布式锁是这样的：
		setnx  key value
			只有一个人能够uname设置值，等他使用完毕之后，del删除这个数据，其他人
				就可以再进行加锁了。
			只有第一次设置的时候才成功。
			setnx uname zs
			<integer> 1
			
			setnx uname zs
			<integer> 0

		有A用户，进行
			setnx uname zs
			持有锁了。但是A宕机了。B永远得不到这个锁了。
		早期的解决方案：
			设置超时时间
			setnx uname zs
			expire uname 30 

		但是
			setnx uname zs
			expire uname 30 
			不是一个原子性的。

	从2.6.12之后，就不推荐用setnx，因为setnx不是原子性的。
		
		set key value ex 10 nx
		成功返回ok
		失败返回nil
		
	10秒钟之后自动过期。					

==============================================================
开发中用redssion:
==============================================================
Redis的持久化：
	
redis是基于内存的。
reids的持久化是2种：

加载配置文件的启动，建立快捷方式。
	F:\udisk\PPT\Redis\Redis\redis-server.exe Redis.conf

默认是RDB模式：
RDB
	在某一个时间段，会自动保存当前时间段内的所有数据，并且保存到RDB文件中

	#   after 900 sec (15 min) if at least 1 key changed
	#   after 300 sec (5 min) if at least 10 keys changed
	#   after 60 sec if at least 10000 keys changed
	save 900 1
	save 300 10
	save 60 10000

	有可能会丢失最后一部分数据。
AOF
	appendonly File

	配置文件中有 appendonly no。 设置成yes,就开启了AOF格式。
	AOF仅仅记录的不是数据，而是命令。
	会记录你操作中的每一步发命令。当然不会丢失最后一部分数据。
	在Redis启动的时候，会把以前的命令全部都执行一遍，所以导致启动速度是很慢的。
=======================================================================================
简历
项目经验：
	1：HR,CRM,某某书城，学生管理系统，网吧管理系统，超市管理系统，电影票。外卖。

=======================================================================================
准备写2年工作经验的：
	3个项目。

如果今年刚毕业：
	
	7月份毕业：
	4月份蜗牛参加培训了。
		这种介绍技术点：

	共享车位：
		用2-3行描述业务。
		1：用Redis来替换Mybatis的二级缓存解决脏读，穿透，雪崩等问题。
		2：用Mybatis的拦截器完成Mybatis的物理分页方言。
		3：用反射+AOP+注解完成项目的行为日志。
		4：用Vue和路由完成页面的静态当页面程序。
		5：用Ajax完成省市区三级下拉框联动。，
		6：一天一天的技术点挪到项目里

	蜗牛商城：
		用2-3行描述业务。

		1：用Ajax完成项目的购物车模块。
		2：用过滤器完成页面的权限校验。
		3：用BootStrap完成前端页面的展示
		4：用Druid完成数据库连接池的配置
		5：用AtomicInteger和Redis的watch完成抢购的行为。
		6：用PowerDesigne完成数据库的构建和建模。
	
	坦克大战：
		1：用工厂模式完成坦克和子弹的构建。
		2：用单例模式完成Boss的构建。
		3：用MVC完成项目的整体架构


	计算器：
		
=======================================================================================

		
		





	