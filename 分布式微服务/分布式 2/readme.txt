��λ�ȡ�ող�������id:

MySql:
	��ֹʹ��
	SELECT MAX(uid) FROM userinfo
	��Ϊ�ڲ��������£��������Ǵ�ġ�

	#mysql�Դ��ĺ�������� ��ȡ��ǰ�߳���ִ�е����һ�����ݵ�����id

	SELECT LAST_INSERT_ID() 
	SELECT @@identity

	�����ϼ����
	SET @count:=0;
	SELECT @count:=@count+1,u.* FROM userinfo u

	#truncate��delete������
	delete����DML,�������ݻ����ع��Σ�֧��rollback��commit�����������ݵ�����id.
	TRUNCATE �ض�  ������DDL�����ݲ������ع��Σ�û��rollback��commit�ĸ��
		���������ݵ�������id.

	mysql�������������
		mysql���������ڴ�@@identity�У�������û���ˡ�


Mybatis:
	<insert id="save" useGenerateKey="uid" keyProperty="uid">

	������ɺ��ʵ���У��Զ�����uid�������ˡ�

Hibernate:
	ʲô�����øɣ��Զ�������ɣ�����ͱ�ɳ־�̬���־�̬�ĵ�����������������id��


Java:
	����Լ�����һ����������id.
	private static int count = 0;//�ڴ��е�count
	private static int cache = 20;//����Ĵ�С
	private static int txtcount = 0;//�ı��ļ��е�count

	public static int getIncrement(){
		if(count==txtcount||count>txtcount){
			//Ŀǰû�������ļ��Ĵ���  
			if	���������ļ� 
				count=0 
				txtcount= cache;  //txtcount = 20;
			//Ŀǰ�������ļ�
			else	�������������ļ�
				txtcount= txtcount+cache;
			
		    count++;	
		}else{
			count++;
		}
		return count;
	}

Oracle:
	Oracleû��������ֻ�����С����ܿ����ú������������ȵ�ģ��������Ҳû�����塣

	���еĴ����﷨��
		create sequence lz_seq

	��εõ����У�
		select lz_seq.nextval from dual

	insert into lz values (lz_seq.nextval,'zs')

	create sequence aseq cache 20






	



