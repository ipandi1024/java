�ľ���Ȼ��
Ψһ�ܸɵ��£��úñ����úø�ϰ������������

Eureka�ĸ߿���

Spring cloud:

�ṩ�ߺ������߶����Լ�ע�ᵽEureka�ϡ�

��������Ҫ�����ṩ����ͨ��Eureka�����ʵ� ��Ⱥ�͸��ؾ��⡣

Eureka���ˣ���ĳ���������
	�������Eureka���ˣ�����ķ�λ�����ڻ���ĶԷ��ĵ�ַ��API�б�������ĳ�����Ȼ���������ġ�
	���ǣ����ᷢ���µ��ṩ��ʵ���� ���е��ṩ�߹��ˣ�EurekaҲ����֪�����ṩ�߷��ʵ�ʱ��
	�����ٽ��б䶯��ֱ�ӱ���

��Eureka�ĸ߿��ã�

1��
#����ǰ�����ļ�������������������
#STEP1�� ����hosts�ļ�  han1 han2 han3  ==========>127.0.0.1
#  C:\Windows\System32\drivers\etc  127.0.0.1 han1 han2 han3
#  ͨ��ping����֤�����Ƿ�����

2��yml
	
spring:
  application:
    name: eureka
---
spring:
  profiles:  #��ǰ�������ļ�������
    han1  #�����Han1�������ļ�����  �Ǹ���ǰ���������ƾ���han1
server:
  port: 9997
eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://han2:9998/eureka/,http://han3:9999/eureka/
  instance:
    hostname: han1  #��ǰ���������ƾ���han1
    prefer-ip-address: true

---
spring:
  profiles:  #��ǰ�������ļ�������
    han2  #�����Han1�������ļ�����  �Ǹ���ǰ���������ƾ���han1
server:
  port: 9998
eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://han1:9997/eureka/,http://han3:9999/eureka/
  instance:
    hostname: han2  #��ǰ���������ƾ���han1
    prefer-ip-address: true

---
spring:
  profiles:  #��ǰ�������ļ�������
    han3  #�����Han1�������ļ�����  �Ǹ���ǰ���������ƾ���han1
server:
  port: 9999
eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://han1:9997/eureka/,http://han2:9998/eureka/
  instance:
    hostname: han3  #��ǰ���������ƾ���han1
    prefer-ip-address: true

3:ָ�������ļ���������
	��� Edit Configuration===>
	���+�ţ�ѡ��Spring Boot===>��name,����Main Class,������Ҫ�����������ļ����ơ�

=======================================
Eureka����֤��
	�����������£�Eureka�϶������������ʣ������¼����ܷ��ʡ�

	Ȩ�޿�ܣ�
		Shiro
		Spring Security
		OAuth2

1:��Ŀpom.xml����
	Spring Security�İ���
	<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>

2:ʹ��spring ��security��
	yml�ĸı�

	spring:
		  application:
		    name: eureka
		  security:
		    user:
		      name: admin
		      password: ilovelaohan

		#����ǰ�����ļ�������������������
		#STEP1�� ����hosts�ļ�  han1 han2 han3  ==========>127.0.0.1
		#  C:\Windows\System32\drivers\etc  127.0.0.1 han1 han2 han3
		#  ͨ��ping����֤�����Ƿ�����

		---
		spring:
		  profiles:  #��ǰ�������ļ�������
		    han1  #�����Han1�������ļ�����  �Ǹ���ǰ���������ƾ���han1
		server:
		  port: 9997
		eureka:
		  client:
		    register-with-eureka: true
		    fetch-registry: true
		    service-url:
		      defaultZone: http://admin:ilovelaohan@han2:9998/eureka/,http://admin:ilovelaohan@han3:9999/eureka/
		  instance:
		    hostname: han1  #��ǰ���������ƾ���han1
		    prefer-ip-address: true

		---
		spring:
		  profiles:  #��ǰ�������ļ�������
		    han2  #�����Han1�������ļ�����  �Ǹ���ǰ���������ƾ���han1
		server:
		  port: 9998
		eureka:
		  client:
		    register-with-eureka: true
		    fetch-registry: true
		    service-url:
		      defaultZone: http://admin:ilovelaohan@han1:9997/eureka/,http://admin:ilovelaohan@han3:9999/eureka/
		  instance:
		    hostname: han2  #��ǰ���������ƾ���han1
		    prefer-ip-address: true

		---
		spring:
		  profiles:  #��ǰ�������ļ�������
		    han3  #�����Han1�������ļ�����  �Ǹ���ǰ���������ƾ���han1
		server:
		  port: 9999
		eureka:
		  client:
		    register-with-eureka: true
		    fetch-registry: true
		    service-url:
		      defaultZone: http://admin:ilovelaohan@han1:9997/eureka/,http://admin:ilovelaohan@han2:9998/eureka/
		  instance:
		    hostname: han3  #��ǰ���������ƾ���han1
		    prefer-ip-address: true

3:���������һ�����⣬csrfУ������⡣
	��cloud2.0���ϰ汾Ĭ�ϾͿ�����csrfУ�飬��Ҫ�ֹ��رա�

=======================================================
cloudԶ�̵�����3�ַ�ʽ��

HttpClient
RestTemplate:
	restTemplate.getForObject("url��ַ",����);
Feign�ͻ���
	αHttp�ͻ��ˣ��ײ���Ȼ�ǵ���URL������о����ڱ��ص���һ����
	���пɲ���ԣ����Զ�̬����Ӻͽ����Ƴ���
	Ĭ�ϼ�����ribbon,����ֱ��ʵ�ּ�Ⱥ�͸��ؾ����������
	Ĭ�ϼ�����hystrix,����ֱ�����۶Ϻͷ��񽵼���

���ʹ��Feign�ͻ��ˣ�

1��pom.xml
	<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>

2:������
	@EnableEurekaClient
	@EnableDiscoveryClient
	@EnableFeignClients

3��yml
	����ǰ��ȫһ��
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
		http://admin:ilovelaohan@localhost:9999/eureka/,http://admin:ilovelaohan@localhost:9998/eureka/,http://admin:ilovelaohan@localhost:9997/eureka/ #Eureka�ķ������ĵ�ַ
	    register-with-eureka: true
	    fetch-registry: true
	  instance:
	    prefer-ip-address: true

4��UserinfoService
	@Component
	@FeignClient("http://PROVIDER/") //���ֵ�������ṩ�ߵ�ʵ������
	public interface UserinfoService {
	    @GetMapping("findAll")//�����ṩ���ṩ��API�ĵ�ַ
	    public List findAll();
	}

5��Controller
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
��־�����кܶ��֣�

Apache Common Log
Log4J
SLF4J

Log4J������־��
myBatis,Hibernate,Spring�ȵȶ��ǿ�������Log4J��

1�����˵Ŀ��ʹ��Log4J��
	log4j.rootLogger=error, stdout, file

	������7��
		OFF FATAL ERROR WARN INFO DEBUG ALL

2: �����Ŀ���ʹ��Log4J
	
	
