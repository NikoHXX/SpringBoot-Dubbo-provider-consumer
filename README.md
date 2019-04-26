#### 1.	本项目分为三个子项目，第一个为Interface,提供者和消费者都引用的这个jar，进入项目install即可在dubbo-provider和dubbo-consumer的pom中引用。

#### 2.	先安装zookerper注册中心，然后安装Dubbo可视化界面(监控中心)，详见本人博客https://www.hxxzt.com/article/dubbo

#### 3.	记录整合的一个坑，消费者端(dubbo-consumer)
```
2019-04-26 12:14:53,840 WARN [com.alibaba.dubbo.config.AbstractConfig] -  [DUBBO] null, dubbo version: 2.6.2, current host: 192.168.0.37
java.lang.reflect.InvocationTargetException
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at com.alibaba.dubbo.config.AbstractConfig.toString(AbstractConfig.java:474)
	at java.lang.String.valueOf(String.java:2994)
	at java.lang.StringBuilder.append(StringBuilder.java:131)
	at com.alibaba.dubbo.config.spring.beans.factory.annotation.AbstractAnnotationConfigBeanBuilder.build(AbstractAnnotationConfigBeanBuilder.java:79)
	at com.alibaba.dubbo.config.spring.beans.factory.annotation.ReferenceAnnotationBeanPostProcessor.buildReferenceBean(ReferenceAnnotationBeanPostProcessor.java:385)
	at com.alibaba.dubbo.config.spring.beans.factory.annotation.ReferenceAnnotationBeanPostProcessor.access$100(ReferenceAnnotationBeanPostProcessor.java:65)
	at com.alibaba.dubbo.config.spring.beans.factory.annotation.ReferenceAnnotationBeanPostProcessor$ReferenceFieldElement.inject(ReferenceAnnotationBeanPostProcessor.java:363)
	at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:90)
	at com.alibaba.dubbo.config.spring.beans.factory.annotation.ReferenceAnnotationBeanPostProcessor.postProcessPropertyValues(ReferenceAnnotationBeanPostProcessor.java:92)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1416)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:592)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:515)
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:320)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:222)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:318)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199)
	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:277)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1247)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1167)
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:593)
	at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:90)
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessProperties(AutowiredAnnotationBeanPostProcessor.java:374)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1411)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:592)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:515)
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:320)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:222)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:318)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:849)
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:877)
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:549)
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:142)
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:775)
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:397)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:316)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1260)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1248)
	at com.hxxzt.dubboconsumer.DubboConsumerApplication.main(DubboConsumerApplication.java:12)
Caused by: java.lang.IllegalStateException: Failed to check the status of the service com.hxxzt.publicinterface.service.IUserDubboProviderService. No provider available for the service com.hxxzt.publicinterface.service.IUserDubboProviderService from the url zookeeper://60.205.223.xxx:2181/com.alibaba.dubbo.registry.RegistryService?application=consumer&dubbo=2.6.2&interface=com.hxxzt.publicinterface.service.IUserDubboProviderService&methods=getUserAddressList&pid=6757&register.ip=192.168.0.37&revision=1.0-SNAPSHOT&side=consumer&timestamp=1556252093545 to the consumer 192.168.0.37 use dubbo version 2.6.2
	at com.alibaba.dubbo.config.ReferenceConfig.createProxy(ReferenceConfig.java:422)
	at com.alibaba.dubbo.config.ReferenceConfig.init(ReferenceConfig.java:333)
	at com.alibaba.dubbo.config.ReferenceConfig.get(ReferenceConfig.java:163)
	at com.alibaba.dubbo.config.spring.ReferenceBean.getObject(ReferenceBean.java:66)
	... 43 more

```

报这个错是因为在CityDubboConsumerServiceImpl中的@Reference注解,没有给version
```java
@Service
public class CityDubboConsumerServiceImpl implements IOrderDubboConsumerService {

    @Reference//dubbo远程引用service服务
    private IUserDubboProviderService userDubboProviderService;

    @Override
    public List<UserAddress> initOrder(Integer userId) {
        System.out.println("用户Id:" + userId);
        List<UserAddress> addressList = userDubboProviderService.getUserAddressList(userId);
        return addressList;
    }
}
```
改成以下即可
```java
@Service
public class CityDubboConsumerServiceImpl implements IOrderDubboConsumerService {

    @Reference(version = "1.0.0")//dubbo远程引用service服务
    private IUserDubboProviderService userDubboProviderService;

    @Override
    public List<UserAddress> initOrder(Integer userId) {
        System.out.println("用户Id:" + userId);
        List<UserAddress> addressList = userDubboProviderService.getUserAddressList(userId);
        return addressList;
    }
}
```
>   在网上看到的答案是大多是说jar包问题，没有任何作用

#### 4.	关于Dubbo的安装及使用，请关注我的博客：www.hxxzt.com
