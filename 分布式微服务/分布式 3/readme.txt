心静自然凉
唯一能干的事，好好背，好好复习。别无他法。

Eureka的高可用

Spring cloud:

提供者和消费者都把自己注册到Eureka上。

消费者需要访问提供者是通过Eureka来访问的 集群和负载均衡。

Eureka挂了，你的程序还正常吗？
	即便你的Eureka挂了，程序的方位还存在缓存的对方的地址和API列表，所以你的程序依然还是正常的。
	但是，不会发现新的提供者实例。 既有的提供者挂了，Eureka也不会知道，提供者访问的时候
	不会再进行变动，直接报错。

做Eureka的高可用：

1：
#给当前配置文件设置三个主配置描述
#STEP1： 更改hosts文件  han1 han2 han3  ==========>127.0.0.1
#  C:\Windows\System32\drivers\etc  127.0.0.1 han1 han2 han3
#  通过ping来验证设置是否正常

2：yml
	
spring:
  application:
    name: eureka
---
spring:
  profiles:  #当前的配置文件的名称
    han1  #如果以Han1的配置文件运行  那个当前的主机名称就是han1
server:
  port: 9997
eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://han2:9998/eureka/,http://han3:9999/eureka/
  instance:
    hostname: han1  #当前主机的名称就是han1
    prefer-ip-address: true

---
spring:
  profiles:  #当前的配置文件的名称
    han2  #如果以Han1的配置文件运行  那个当前的主机名称就是han1
server:
  port: 9998
eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://han1:9997/eureka/,http://han3:9999/eureka/
  instance:
    hostname: han2  #当前主机的名称就是han1
    prefer-ip-address: true

---
spring:
  profiles:  #当前的配置文件的名称
    han3  #如果以Han1的配置文件运行  那个当前的主机名称就是han1
server:
  port: 9999
eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://han1:9997/eureka/,http://han2:9998/eureka/
  instance:
    hostname: han3  #当前主机的名称就是han1
    prefer-ip-address: true

3:指定配置文件进行运行
	点击 Edit Configuration===>
	点击+号，选择Spring Boot===>改name,填入Main Class,填入你要启动的配置文件名称。

=======================================
Eureka的认证：
	在生产条件下，Eureka肯定不能匿名访问，必须登录后才能访问。

	权限框架：
		Shiro
		Spring Security
		OAuth2

1:项目pom.xml导入
	Spring Security的包。
	<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>

2:使用spring 的security。
	yml的改变

	spring:
		  application:
		    name: eureka
		  security:
		    user:
		      name: admin
		      password: ilovelaohan

		#给当前配置文件设置三个主配置描述
		#STEP1： 更改hosts文件  han1 han2 han3  ==========>127.0.0.1
		#  C:\Windows\System32\drivers\etc  127.0.0.1 han1 han2 han3
		#  通过ping来验证设置是否正常

		---
		spring:
		  profiles:  #当前的配置文件的名称
		    han1  #如果以Han1的配置文件运行  那个当前的主机名称就是han1
		server:
		  port: 9997
		eureka:
		  client:
		    register-with-eureka: true
		    fetch-registry: true
		    service-url:
		      defaultZone: http://admin:ilovelaohan@han2:9998/eureka/,http://admin:ilovelaohan@han3:9999/eureka/
		  instance:
		    hostname: han1  #当前主机的名称就是han1
		    prefer-ip-address: true

		---
		spring:
		  profiles:  #当前的配置文件的名称
		    han2  #如果以Han1的配置文件运行  那个当前的主机名称就是han1
		server:
		  port: 9998
		eureka:
		  client:
		    register-with-eureka: true
		    fetch-registry: true
		    service-url:
		      defaultZone: http://admin:ilovelaohan@han1:9997/eureka/,http://admin:ilovelaohan@han3:9999/eureka/
		  instance:
		    hostname: han2  #当前主机的名称就是han1
		    prefer-ip-address: true

		---
		spring:
		  profiles:  #当前的配置文件的名称
		    han3  #如果以Han1的配置文件运行  那个当前的主机名称就是han1
		server:
		  port: 9999
		eureka:
		  client:
		    register-with-eureka: true
		    fetch-registry: true
		    service-url:
		      defaultZone: http://admin:ilovelaohan@han1:9997/eureka/,http://admin:ilovelaohan@han2:9998/eureka/
		  instance:
		    hostname: han3  #当前主机的名称就是han1
		    prefer-ip-address: true

3:启动会会有一个问题，csrf校验的问题。
	从cloud2.0以上版本默认就开启了csrf校验，需要手工关闭。

=======================================================
cloud远程调用有3种方式：

HttpClient
RestTemplate:
	restTemplate.getForObject("url地址",类型);
Feign客户端
	伪Http客户端，底层仍然是调用URL，让你感觉像在本地调用一样。
	具有可插拔性，可以动态的添加和进行移除。
	默认集成了ribbon,可以直接实现集群和负载均衡的能力。
	默认集成了hystrix,可以直接做熔断和服务降级。

如何使用Feign客户端：

1：pom.xml
	<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>

2:启动类
	@EnableEurekaClient
	@EnableDiscoveryClient
	@EnableFeignClients

3：yml
	跟以前完全一样
	server:
	  port: 10001

	spring:
	  application:
	    name: feigncustomer

	user:
	  userSericeURL: http://PROVIDER/

	eureka:
	  client:
	    service-url:
	      defaultZone:
		http://admin:ilovelaohan@localhost:9999/eureka/,http://admin:ilovelaohan@localhost:9998/eureka/,http://admin:ilovelaohan@localhost:9997/eureka/ #Eureka的服务器的地址
	    register-with-eureka: true
	    fetch-registry: true
	  instance:
	    prefer-ip-address: true

4：UserinfoService
	@Component
	@FeignClient("http://PROVIDER/") //这个值就是你提供者的实例名称
	public interface UserinfoService {
	    @GetMapping("findAll")//就是提供者提供的API的地址
	    public List findAll();
	}

5：Controller
	@RestController
	public class UserinfoController {
	    @Resource
	    private UserinfoService userinfoService;
	    @GetMapping("/findAll")
	    public List findAll(){
		return userinfoService.findAll();
	    }
	}
=======================================================
日志工具有很多种：

Apache Common Log
Log4J
SLF4J

Log4J处理日志：
myBatis,Hibernate,Spring等等都是可以适配Log4J。

1：别人的框架使用Log4J。
	log4j.rootLogger=error, stdout, file

	级别有7种
		OFF FATAL ERROR WARN INFO DEBUG ALL

2: 你的项目如何使用Log4J
	
	
