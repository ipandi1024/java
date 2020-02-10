迄今为止，我们学习的spring配置的方式有：
1. xml中显示配置， <bean>
2. xml中隐式配置， 扫包 + 类上写注解   <context:component-scan basePackags="" />
3. javaconfig显示配置，  @Bean 
4. javaconfig隐式配置，扫包 + 类上写注解  @ComponentScan

问题是，上面的这4中配置写法，能不能混合在一起！ 能！！

下面要学习的步骤：
a. xml方式  引入 xml方式
b. xml方式 引入 javaconfig
c. javaconfig 引入 xml
d. javaconfig 引入 javaconfig