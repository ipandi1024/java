Hystrix熔断：
	为什么要有熔断。避免雪崩。
	因为某一个节点的运行速度过慢，而产生堵塞。最终有可能导致全部系统产生雪崩。
	生活中的列子：
		老潘，高鹏都是拉面师傅。
		老潘现在拉肚子了，导致拉面效率低下。因为我们采取集群。最终导致老潘
		排队过多。老潘导致堵塞。传菜员也会堵塞，服务员也会堵塞。最终的结果拉面馆
		倒闭。

一：降级
	海底捞吃饭，上菜速度过慢。
		---》吃鲍鱼
		---》先给你端过来一盘水果。
		
		老吃水果，阈值(20秒10次，有一半都是失败,认为后台的厨子有可能已经挂了)。
		应该直接熔断。
	

	一个提供者  一个Eureka 一个消费者


	如果不写降级：
		有可能我们的提供者出错。

如何给消费者加入熔断器：

1：pom.xml
	<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-netflix-hystrix</artifactId>
		</dependency>

2:找到主启动类加入注解
	@EnableCircuitBreaker

3：给方法写降级方法。
	@GetMapping("/say")
	@HystrixCommand(fallbackMethod="error")
	public String say() {
		return restTemplate.getForObject(userSericeURL+"findAll", String.class);
	}
	
	public String error() {
		return "程序错误，发生降级";
	}
	
有四种条件会引发服务降级（给后台服务发请求，但是也直接给用户返回信息）：
		消费者---->Eureka---->提供者

降级发生，仍然会进入提供者。
		1：异常
		2：超时
			hystrix的超时，默认是1S。
		3：线程池/信号量已经满了的情况下。
			设置默认熔断器的线程池的数量
			hystrix:  
			    threadpool: 
			      default: 
				coreSize : 10   #核心线程数 200 #并发执行的最大线程数，默认10  

			模拟线程并发运行：
				1：上测试工具 
					
				2: 自己用Java写多线程并发来进行测试。
					Thread: start 线程并不是同时开启的。
					CountDownLatch（倒计时，闭锁）：
						所有的线程一定是同时开启的。
			
		4：熔断
			熔断器打开后，程序就不再请求提供者了。直接降级。

			规则是这样的：
			默认
			1、  当满足一定的阀值的时候（默认10秒内超过20个请求次数）

			2、  当失败率达到一定的时候（默认10秒内超过50%的请求失败）
			
			3：熔断器进行打开，打开熔断器。打开的时间为5秒。
				5秒之后，是个半开状态。
				会放行1次请求。
					1：还是降级  打开熔断器。
					2：正常了  关闭熔断器

				

二：熔断

挂载DashBoard。
