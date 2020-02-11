如何获取刚刚插入数据id:

MySql:
	禁止使用
	SELECT MAX(uid) FROM userinfo
	因为在并发条件下，这个结果是错的。

	#mysql自带的函数来完成 获取当前线程内执行的最后一条数据的自增id

	SELECT LAST_INSERT_ID() 
	SELECT @@identity

	给列上加序号
	SET @count:=0;
	SELECT @count:=@count+1,u.* FROM userinfo u

	#truncate和delete的区别？
	delete属于DML,操作数据会放入回滚段，支持rollback和commit。保留了数据的自增id.
	TRUNCATE 截断  ，属于DDL，数据不会放入回滚段，没有rollback和commit的概念。
		不保留数据的自增的id.

	mysql的自增放在那里？
		mysql自增放在内存@@identity中，重启就没有了。


Mybatis:
	<insert id="save" useGenerateKey="uid" keyProperty="uid">

	插入完成后的实体中，自动就有uid的自增了。

Hibernate:
	什么都不用干，自动插入完成，对象就变成持久态，持久态的典型特征就是有主键id。


Java:
	如何自己生成一个主键自增id.
	private static int count = 0;//内存中的count
	private static int cache = 20;//缓存的大小
	private static int txtcount = 0;//文本文件中的count

	public static int getIncrement(){
		if(count==txtcount||count>txtcount){
			//目前没有配置文件的存在  
			if	创建配置文件 
				count=0 
				txtcount= cache;  //txtcount = 20;
			//目前有配置文件
			else	重新设置配置文件
				txtcount= txtcount+cache;
			
		    count++;	
		}else{
			count++;
		}
		return count;
	}

Oracle:
	Oracle没有自增，只有序列。尽管可以用函数，触发器等等模拟自增，也没有意义。

	序列的创建语法：
		create sequence lz_seq

	如何得到序列：
		select lz_seq.nextval from dual

	insert into lz values (lz_seq.nextval,'zs')

	create sequence aseq cache 20






	



