# ABC   



                                                          Netflix 组件


1.eureka:
  server.port=7001     
  spring.application.name=server
  eureka.instance.hostname=server
  eureka.client.fetch-registry=true
  eureka.client.register-with-eureka=true
  eureka.client.serviceUrl.defaultZone=http://server:7001/eureka,xxx    //相互注册，实现集群
  失效剔除：有些时候，我们的服务实例并不一定会正常下线，可能由于内存溢出、网络故障等原因使服务不能正常运作。而服务注册中心

并未收到“服务下线”的请求，为了从服务列表中将这些无法提供服务的实例剔除，Eureka Server在启动的时候会创建一个定时任务，默

认每隔一段时间（默认为60秒）将当前清单中超时（默认为90秒）没有续约的服务剔除出去。
  (1)eureka.instance.lease-expiration-duration-in-seconds：表示eureka server至上一次收到client的心跳之后，等待下一次心跳的

超时时间(默认90秒)，在这个时间内若没收到下一次心跳，则将移除该instance。(该值至少应该大于下面的值)
  (2)eureka.instance.lease-renewal-interval-in-seconds: eureka client发送心跳给server端的频率，默认30秒，此时间过后server

端没有收到client的心跳，则将摘除该instance


  
  自我保护：服务注册到Eureka Server后，会维护一个心跳连接，告诉Eureka Server自己还活着。Eureka Server在运行期间会统计心跳

失败的比例在15分钟以之内是否低于85%，如果出现低于的情况，Eureka Server会将当前实例注册信息保护起来，让这些实例不会过期。这

样做会使客户端很容易拿到实际已经不存在的服务实例，会出现调用失败的情况。因此客户端要有容错机制，比如请求重试、断路器。

  安全认证：我们启动了Eureka Server，然后在浏览器中输入http://localhost:8761/后，直接回车，就进入了spring cloud的服务治理

页面，这么做在生产环境是极不安全的，下面，我们就给Eureka Server加上安全的用户认证.
  (1).添加依赖
    <dependency>  
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
    </dependency>
  (2).application.properties配置文件
    spring.security.user.name=hjj
    spring.security.user.password=123

2.ribbon:







3.hystrix:
