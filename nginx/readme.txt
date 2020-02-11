一、 概念

Nginx——Ngine X，是一款自由的、开源的、高性能HTTP服务器和反向代理服务器；也是一个IMAP、POP3、SMTP代理服务器；也就是说Nginx本身就可以托管网站（类似于Tomcat一样），进行Http服务处理，也可以作为反向代理服务器使用。

Nginx 解决了服务器的C10K（就是在一秒之内连接客户端的数目为10k即1万）问题。它的设计不像传统的服务器那样使用线程处理请求，而是一个更加高级的机制—事件驱动机制，是一种异步事件驱动结构。

二、 正向代理和反向代理

首先，代理服务器一般指局域网内部的机器通过代理服务器发送请求到互联网上的服务器，代理服务器一般作用在客户端。例如：GoAgent翻墙软件。我们的客户端在进行翻墙操作的时候，我们使用的正是正向代理，通过正向代理的方式，在我们的客户端运行一个软件，将我们的HTTP请求转发到其他不同的服务器端，实现请求的分发。

反向代理服务器作用在服务器端，它在服务器端接收客户端的请求，然后将请求分发给具体的服务器进行处理，然后再将服务器的相应结果反馈给客户端。Nginx就是一个反向代理服务器软件。

Nginx("engine x")是一款是由俄罗斯的程序设计师Igor Sysoev所开发高性能的 Web和 反向代理 服务器，也是一个 IMAP/POP3/SMTP 代理服务器。

在高连接并发的情况下，Nginx是Apache服务器不错的替代品。

==============================
1：Nginx启动：
	start nginx.exe
	nginx -s reload  nginx可以重新加载文件
	nginx -t #查看配置文件是否有错
==============================
2：Nginx整合Tomcat:
	修改nginx.conf文件。
	listen：表示当前的代理服务器监听的端口，默认的是监听80端口。注意，如果我们配置了多个server，这个listen要配		置不一样，不然就不能确定转到哪里去了。

	server_name：表示监听到之后需要转到哪里去，这时我们直接转到本地，这时是直接到nginx文件夹内。

	location：表示匹配的路径，这时配置了/表示所有请求都被匹配到这里

	root：里面配置了root这时表示当匹配这个请求的路径时，将会在这个文件夹内寻找相应的文件，这里对我们之后的静态文件伺服很有用。

	index：当没有指定主页时，默认会选择这个指定的文件，它可以有多个，并按顺序来加载，如果第一个不存在，则找第二个，依此类推。

	实际上就修改两个地方：


	server_name localhost:8080;  
	  
	location / {  
	    proxy_pass http://localhost:8080;  
	}  
	proxy_pass，它表示代理路径，相当于转发，而不像之前说的root必须指定一个文件夹

	打完收工。
==============================
3: 动静分离
	
	location / {
            root   html;
            index  index.html index.htm;
	    proxy_pass http://localhost:9000;
        }

	# 所有动态请求都转发给tomcat处理 
	#    location ~ \.(jsp|do)$ { 
	#	proxy_next_upstream http_502 http_504 error timeout invalid_header;
	#	proxy_pass http://localhost:9000;
	#    } 


	#静态文件交给nginx处理
        location ~ .*\.(htm|html|gif|jpg|jpeg|png|bmp|swf|ioc|rar|zip|txt|flv|mid|doc|ppt|pdf|xls|mp3|wma)$
        {
                root  G:\work\2018\prj04\src\main\webapp;
                expires 30d;
        }
        #静态文件交给nginx处理
        location ~ .*\.(js|css)?$
        {
                root G:\work\2018\prj04\src\main\webapp;
                expires 1h;
        }
==============================
4: 负载均衡
	1：启动两个tomcat
	2: 修改配置文件
		新增
		#服务器的集群  
		upstream  127.0.0.1 {  #服务器集群名字   
		   server 127.0.0.1:8082  weight=1;#服务器配置 weight是权重的意思，权重越大，分配的概率越大。  
		   server 127.0.0.1:8081  weight=2;  
		}
	3：修改
		location / {
		    root   html;
		    index  index.html index.htm;
		    proxy_pass http://127.0.0.1;
		    proxy_redirect default;  
		}
================================
配置文件如下：
#服务器的集群  
	upstream  127.0.0.1 {  #服务器集群名字   
	   server 127.0.0.1:8082  weight=1;#服务器配置 weight是权重的意思，权重越大，分配的概率越大。  
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


	#静态文件交给nginx处理
        location ~ .*\.(htm|html|gif|jpg|jpeg|png|bmp|swf|ioc|rar|zip|txt|flv|mid|doc|ppt|pdf|xls|mp3|wma)$
        {
                root  G:\work\2018\prj14\src\main\webapp;
                expires 30d;
        }
        #静态文件交给nginx处理
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
	
	#session存储类型
	spring.session.store-type=redis
	#设置session超时时间
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

打完收工。