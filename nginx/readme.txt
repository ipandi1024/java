һ�� ����

Nginx����Ngine X����һ�����ɵġ���Դ�ġ�������HTTP�������ͷ�������������Ҳ��һ��IMAP��POP3��SMTP�����������Ҳ����˵Nginx����Ϳ����й���վ��������Tomcatһ����������Http������Ҳ������Ϊ������������ʹ�á�

Nginx ����˷�������C10K��������һ��֮�����ӿͻ��˵���ĿΪ10k��1�����⡣������Ʋ���ͳ�ķ���������ʹ���̴߳������󣬶���һ�����Ӹ߼��Ļ��ơ��¼��������ƣ���һ���첽�¼������ṹ��

���� �������ͷ������

���ȣ����������һ��ָ�������ڲ��Ļ���ͨ������������������󵽻������ϵķ����������������һ�������ڿͻ��ˡ����磺GoAgent��ǽ��������ǵĿͻ����ڽ��з�ǽ������ʱ������ʹ�õ������������ͨ���������ķ�ʽ�������ǵĿͻ�������һ������������ǵ�HTTP����ת����������ͬ�ķ������ˣ�ʵ������ķַ���

�����������������ڷ������ˣ����ڷ������˽��տͻ��˵�����Ȼ������ַ�������ķ��������д���Ȼ���ٽ�����������Ӧ����������ͻ��ˡ�Nginx����һ�������������������

Nginx("engine x")��һ�����ɶ���˹�ĳ������ʦIgor Sysoev�����������ܵ� Web�� ������� ��������Ҳ��һ�� IMAP/POP3/SMTP �����������

�ڸ����Ӳ���������£�Nginx��Apache��������������Ʒ��

==============================
1��Nginx������
	start nginx.exe
	nginx -s reload  nginx�������¼����ļ�
	nginx -t #�鿴�����ļ��Ƿ��д�
==============================
2��Nginx����Tomcat:
	�޸�nginx.conf�ļ���
	listen����ʾ��ǰ�Ĵ�������������Ķ˿ڣ�Ĭ�ϵ��Ǽ���80�˿ڡ�ע�⣬������������˶��server�����listenҪ��		�ò�һ������Ȼ�Ͳ���ȷ��ת������ȥ�ˡ�

	server_name����ʾ������֮����Ҫת������ȥ����ʱ����ֱ��ת�����أ���ʱ��ֱ�ӵ�nginx�ļ����ڡ�

	location����ʾƥ���·������ʱ������/��ʾ�������󶼱�ƥ�䵽����

	root������������root��ʱ��ʾ��ƥ����������·��ʱ������������ļ�����Ѱ����Ӧ���ļ������������֮��ľ�̬�ļ��ŷ������á�

	index����û��ָ����ҳʱ��Ĭ�ϻ�ѡ�����ָ�����ļ����������ж��������˳�������أ������һ�������ڣ����ҵڶ������������ơ�

	ʵ���Ͼ��޸������ط���


	server_name localhost:8080;  
	  
	location / {  
	    proxy_pass http://localhost:8080;  
	}  
	proxy_pass������ʾ����·�����൱��ת����������֮ǰ˵��root����ָ��һ���ļ���

	�����չ���
==============================
3: ��������
	
	location / {
            root   html;
            index  index.html index.htm;
	    proxy_pass http://localhost:9000;
        }

	# ���ж�̬����ת����tomcat���� 
	#    location ~ \.(jsp|do)$ { 
	#	proxy_next_upstream http_502 http_504 error timeout invalid_header;
	#	proxy_pass http://localhost:9000;
	#    } 


	#��̬�ļ�����nginx����
        location ~ .*\.(htm|html|gif|jpg|jpeg|png|bmp|swf|ioc|rar|zip|txt|flv|mid|doc|ppt|pdf|xls|mp3|wma)$
        {
                root  G:\work\2018\prj04\src\main\webapp;
                expires 30d;
        }
        #��̬�ļ�����nginx����
        location ~ .*\.(js|css)?$
        {
                root G:\work\2018\prj04\src\main\webapp;
                expires 1h;
        }
==============================
4: ���ؾ���
	1����������tomcat
	2: �޸������ļ�
		����
		#�������ļ�Ⱥ  
		upstream  127.0.0.1 {  #��������Ⱥ����   
		   server 127.0.0.1:8082  weight=1;#���������� weight��Ȩ�ص���˼��Ȩ��Խ�󣬷���ĸ���Խ��  
		   server 127.0.0.1:8081  weight=2;  
		}
	3���޸�
		location / {
		    root   html;
		    index  index.html index.htm;
		    proxy_pass http://127.0.0.1;
		    proxy_redirect default;  
		}
================================
�����ļ����£�
#�������ļ�Ⱥ  
	upstream  127.0.0.1 {  #��������Ⱥ����   
	   server 127.0.0.1:8082  weight=1;#���������� weight��Ȩ�ص���˼��Ȩ��Խ�󣬷���ĸ���Խ��  
	   server 127.0.0.1:8081  weight=2;  
	}

    server {
        listen       80;
        server_name  localhost:9000;

        #charset koi8-r;

        #access_log  logs/host.access.log  main;

        location / {
            root   html;
            index  index.html index.htm;
	    proxy_pass http://127.0.0.1;
	    proxy_redirect default;  
        }


	#��̬�ļ�����nginx����
        location ~ .*\.(htm|html|gif|jpg|jpeg|png|bmp|swf|ioc|rar|zip|txt|flv|mid|doc|ppt|pdf|xls|mp3|wma)$
        {
                root  G:\work\2018\prj14\src\main\webapp;
                expires 30d;
        }
        #��̬�ļ�����nginx����
        location ~ .*\.(js|css)?$
        {
                root G:\work\2018\prj14\src\main\webapp;
                expires 1h;
        }

    }
================================
Spring Session:
1: pom.xml
	
	<dependency>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-data-redis</artifactId>
	 </dependency>
	<dependency>
	     <groupId>org.springframework.session</groupId>
	     <artifactId>spring-session-data-redis</artifactId>
	</dependency>

2: application.properties
	
	#session�洢����
	spring.session.store-type=redis
	#����session��ʱʱ��
	server.session.timeout=2000
	spring.redis.host=127.0.0.1
	spring.redis.port=6379

	server:
	  port: 8001
	  servlet: 
	    session: 
	      cookie: 
		max-age: 1800  
	spring: 
	  session:  
	    store-type: redis
	  redis:  
	    host: 127.0.0.1
	    port: 6379
	    timeout: 3000
	    jedis:  
	      pool: 
	       max-idle: 20
	       min-idle: 5

�����չ���