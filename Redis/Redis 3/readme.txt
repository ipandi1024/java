Redis������������
�����������õ�Redis����ô�õģ�
1����Redis����¼������֤��	
	д�����������
2����Redis���滻Mybatis�Ķ������棬����������͸��������ѩ�������⡣
	д�����������
		������ν���������⡣

3����Redis������ɱ�еĿ�档����ɱ�еĶ�����
	1��watch
	2: set �ֲ�ʽ��
4����Redis�����ֲ�ʽ�е�session����

�Ѻ��ıȽϱ�����
==============================================================

Redis:
	Redis�ǵ��̵߳ġ�

Redis����ɱ��
	ֻ���ǿ�档

	1�����====����������ݿ��У�ÿ��һ���������ݿ���-1.���ݿ���һ�����͵�IO��������ʱ��

	2���ѿ�����Redis�С��ṩ�������е�Ч�ʡ�

=============================================
	1��Redis�еĿ�������

		
	2�������û�������

========================================================
package com.woniu.controller;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyController {
	//�����ǰ�������ݿ��У����ڷ���Redis��
	@Resource
	private RedisTemplate<String, Integer> redisTemplate;
	
	private AtomicInteger buyCount;
	
	//��ʼ������   ������ʱ���ȡ���ݿ��ȡ���ݿ�Ŀ��
	@GetMapping("init")
	public String init() {
		redisTemplate.opsForValue().set("count", 5);
		buyCount = new AtomicInteger(0);
		return "��ʼ�����";
	}
	
	//Buy����Ϊ�����ʱ����Ҫ-1,�û����������+1
	@GetMapping("buy")
	public synchronized String buy() {
		int count = redisTemplate.opsForValue().get("count");
		count=count-1;
		if(count<0) {
			return "�Ѿ�����������������";
		}
		redisTemplate.opsForValue().set("count",count);
		return "�ɹ����򣬹�����"+buyCount.incrementAndGet()+"��";
	}
	
	//�鿴�û��������˼���
	@GetMapping("getCount")
	public String getCount() {
		return "�ܹ�������"+buyCount.get();
	}
}
========================================================
1��ʹ�ÿ��������� int .
	buyCount++;
	
	i++:
			�����������3��ָ�
				get
				+1
				setֵ

			����ָ�����ŵ����⣬CAS���Ƚϲ��ҽ����������⣬����Ҳû�б�֤ԭ���ԡ�

		�߲�������£�һ����AtomicInteger��

2: ��int buyCount����
	private AtomicInteger buyCount;

	���һ�ȡֵ��ʱ��
	 "�ɹ����򣬹�����"+buyCount.incrementAndGet()+"��";

	���ǽ����Ȼ������ԭ���ǣ�
	�����������ԭ���Եġ�����redisTemplate��+buyCount���ھ�Ϊԭ���ԡ�

	public  String buy() {
		int count = redisTemplate.opsForValue().get("count");
		count=count-1;
		if(count<0) {
			return "�Ѿ�����������������";
		}
		redisTemplate.opsForValue().set("count",count);
		return "�ɹ����򣬹�����"+buyCount.incrementAndGet()+"��";
	}

==============================================================
Redis������


JDBC������
	ԭ���� һ����  ������  �־���

	commit  rollback

Redis������Ƚϼ򵥣�ֱ���þ����ˣ�Ҳû����������ԡ�
	Ҳ�����ݿ��������ȫ��һ����

	multi        exec            discard
	��������     ִ������        ��������
	
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

�����м�һ�仰ִ�г����ˣ�Ҳ����Ӱ�����������ִ�У��൱��ֻ��ԭ�����ݿ�������е� ���л���
Ψһ�ܱ�֤���ǣ�ִ���⼸�仰�в����������߳̽���ִ�С����л���
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
Redis��Watch(�ֹ��� һ���Ҫ����һ�����Ի���):
	��Java CAS�ȽϽӽ���ԭ������һ�µġ�

	watch ������ʼ֮ǰ���͹۲�һ��Ԫ�ء�
		���������ǰ�����κ��̣߳��������Լ�����߳� �޸������Ԫ�ص�ֵ��
		��Ϊ����ǰ�����ǲ�Ӧ�ñ��޸ĵģ�����ִ�й��̾���0.�൱�ڲ�ִ�С�

	
AS1��
	set age 1
	watch age
	multi
	set a aaa
		=================>��ʱ����һ���߳� incr age
	set b bbb
	exec===>nil  

AS2��
	set age 1
	watch age
	incr age
	multi
	set a aaa
	set b bbb
	exec===>nil

AS3��
	set age 1
	watch age
	multi
	incr age
	exec===>2 ok


	public void buy() throws InterruptedException {
		Jedis jedis = new Jedis("127.0.0.1",6379);
		while (true) {
			System.out.println("ִ��һ��");
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
Redids�ķֲ�ʽ��������������
	�ֲ�ʽ����ʵ�ַ�ʽ�кö��֣�
		���ݿ⣬��̬������Redis��
	
ԭ��
	Ӧ�þ���һ��ȫ�ֵĹ��õ�����
	���ڵķֲ�ʽ���������ģ�
		setnx  key value
			ֻ��һ�����ܹ�uname����ֵ������ʹ�����֮��delɾ��������ݣ�������
				�Ϳ����ٽ��м����ˡ�
			ֻ�е�һ�����õ�ʱ��ųɹ���
			setnx uname zs
			<integer> 1
			
			setnx uname zs
			<integer> 0

		��A�û�������
			setnx uname zs
			�������ˡ�����A崻��ˡ�B��Զ�ò���������ˡ�
		���ڵĽ��������
			���ó�ʱʱ��
			setnx uname zs
			expire uname 30 

		����
			setnx uname zs
			expire uname 30 
			����һ��ԭ���Եġ�

	��2.6.12֮�󣬾Ͳ��Ƽ���setnx����Ϊsetnx����ԭ���Եġ�
		
		set key value ex 10 nx
		�ɹ�����ok
		ʧ�ܷ���nil
		
	10����֮���Զ����ڡ�					

==============================================================
��������redssion:
==============================================================
Redis�ĳ־û���
	
redis�ǻ����ڴ�ġ�
reids�ĳ־û���2�֣�

���������ļ���������������ݷ�ʽ��
	F:\udisk\PPT\Redis\Redis\redis-server.exe Redis.conf

Ĭ����RDBģʽ��
RDB
	��ĳһ��ʱ��Σ����Զ����浱ǰʱ����ڵ��������ݣ����ұ��浽RDB�ļ���

	#   after 900 sec (15 min) if at least 1 key changed
	#   after 300 sec (5 min) if at least 10 keys changed
	#   after 60 sec if at least 10000 keys changed
	save 900 1
	save 300 10
	save 60 10000

	�п��ܻᶪʧ���һ�������ݡ�
AOF
	appendonly File

	�����ļ����� appendonly no�� ���ó�yes,�Ϳ�����AOF��ʽ��
	AOF������¼�Ĳ������ݣ��������
	���¼������е�ÿһ���������Ȼ���ᶪʧ���һ�������ݡ�
	��Redis������ʱ�򣬻����ǰ������ȫ����ִ��һ�飬���Ե��������ٶ��Ǻ����ġ�
=======================================================================================
����
��Ŀ���飺
	1��HR,CRM,ĳĳ��ǣ�ѧ������ϵͳ�����ɹ���ϵͳ�����й���ϵͳ����ӰƱ��������

=======================================================================================
׼��д2�깤������ģ�
	3����Ŀ��

�������ձ�ҵ��
	
	7�·ݱ�ҵ��
	4�·���ţ�μ���ѵ�ˡ�
		���ֽ��ܼ����㣺

	����λ��
		��2-3������ҵ��
		1����Redis���滻Mybatis�Ķ����������������͸��ѩ�������⡣
		2����Mybatis�����������Mybatis�������ҳ���ԡ�
		3���÷���+AOP+ע�������Ŀ����Ϊ��־��
		4����Vue��·�����ҳ��ľ�̬��ҳ�����
		5����Ajax���ʡ����������������������
		6��һ��һ��ļ�����Ų����Ŀ��

	��ţ�̳ǣ�
		��2-3������ҵ��

		1����Ajax�����Ŀ�Ĺ��ﳵģ�顣
		2���ù��������ҳ���Ȩ��У�顣
		3����BootStrap���ǰ��ҳ���չʾ
		4����Druid������ݿ����ӳص�����
		5����AtomicInteger��Redis��watch�����������Ϊ��
		6����PowerDesigne������ݿ�Ĺ����ͽ�ģ��
	
	̹�˴�ս��
		1���ù���ģʽ���̹�˺��ӵ��Ĺ�����
		2���õ���ģʽ���Boss�Ĺ�����
		3����MVC�����Ŀ������ܹ�


	��������
		
=======================================================================================

		
		





	