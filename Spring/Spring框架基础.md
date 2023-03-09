<a name="aXeeg"></a>
# 关于框架
框架（FrameWork）是一个可复用的设计构建。
<a name="rUZ6r"></a>
# 关于Spring框架

- **主要为了解决创建对象、管理对象的问题**
- 开发实践中，Spring框架的核心价值在于：开发者可以通过Spring框架提供的机制，将创建对象、管理对象的任务交给Spring来完成，当需要某个对象时只需要通过Spring获取对象即可。**Spring框架通常被称为容器.**
- Spring框架还很好的兼容了AOP

使用Spring框架推荐使用Maven工程，因为只需要使用依赖。<br />使用Spring框架所需的依赖项是`spring-context`。
<a name="ke3x0"></a>
# 通过Spring管理对象
<a name="k8G2n"></a>
## 创建对象的方式
如果需要Spring管理对象，就必须创建对象，然后Spring获取对象才可以进行管理。<br />被Spring管理的对象，通常也称之为**Spring Bean**<br />创建对象的方式有两种：

1. 通过`@Bean`方法
2. 通过组件扫描
<a name="MUr7c"></a>
### 通过`@Bean`方法创建
这里首先新建一个`Maven`工程（`springBasic-01`），然后在`pom.xml`文件中导入项目所需依赖：
```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-context
引入spring框架
-->
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-context</artifactId>
  <version>5.3.18</version>
</dependency>
```
然后在`src.main.java`下新建两个文件：`cdu.zch.spring.SpringBeanFactory`和`cdu.zch.spring.SpringRunner`。<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/35204765/1678188082747-f4f3aca8-961b-403d-afa1-d3f141b8a91d.png#averageHue=%233e4346&clientId=ua12e55ce-ed83-4&from=paste&height=124&id=ude351dfe&name=image.png&originHeight=124&originWidth=244&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4658&status=done&style=none&taskId=uf2b3f90c-8936-4edc-ad18-6fc1c6450c2&title=&width=244)<br />在`SpringBeanFactory`类中写如下代码：
```java
package cdu.zch.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration // 不是必须的，但是规范是@Bean是写在@Configuration下面
public class SpringBeanFactory {


    @Bean // 使Spring自动调用此方法  可以 @Bean("bean name") 这里的名字对应getBean（bean name），默认不传则是方法名
    public Random random(){
        return new Random();
    }

}
```
然后在`SpringRunner`类中测试运行：
```java
package cdu.zch.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

public class SpringRunner {

    public static void main(String[] args) {
        // 1、让Spring跑起来
        /**
         * AnnotationConfigApplicationContext : 用于加载Spring配置，同时是Spring容器
         *
         * 注意：需要在构造方法中添加参数
         * */
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringBeanFactory.class);

        // 2、从Spring中获取对象
        /**
         * 默认的bean name 就是 @Bean 方法的名称，返回值为 Object
         * 还可以传入类型 ac.getBean(Random.class); 但是当两种相同类型不同方法名时会出错
         * 或者既传名字，又可传类型，本质使根据名称获取，这种方法不用转类型 ac.getBean("random", Random.class);
         * */
        Random random = (Random) ac.getBean("random");

        // 3、测试使用
        System.out.println(random);

        // 4、结束
        ac.close();
    }

}
```
输出：
```java
java.util.Random@279ad2e3
```
此时，使用`@Bean`方法创建对象成功。
<a name="oQg9p"></a>
### 通过组件扫描
重新新建一个`Maven`工程（`springBasic-02`），做法和上面一致（`pom.xml`文件记得引入依赖）。只是名字不同。<br />新建`cdu.zch.spring.SpringConfig`、`cdu.zch.spring.SpringRunner`、`cdu.zch.spring.UserMapper`.<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/35204765/1678188399338-65e27109-370b-464c-8298-f86733c183c2.png#averageHue=%23384046&clientId=ua12e55ce-ed83-4&from=paste&height=147&id=u2fc64fbe&name=image.png&originHeight=147&originWidth=210&originalType=binary&ratio=1&rotation=0&showTitle=false&size=6316&status=done&style=none&taskId=u5443675b-24a7-4e1f-83e0-dbd361d0f65&title=&width=210)<br />然后首先`SpringConfig`：
```java
package cdu.zch.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cdu.zch.spring")
public class SpringConfig {

}
```
`UserMapper`
```java
package cdu.zch.spring;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
}
```
`SpringRunner`
```java
package cdu.zch.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringRunner {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserMapper userMapper = ac.getBean(UserMapper.class);

        System.out.println(userMapper);

        ac.close();

    }

}
```
输出：
```java
cdu.zch.spring.UserMapper@41ee392b
```
<a name="VMdZC"></a>
## @Bean和组件扫描对比
<a name="L0WAQ"></a>
### @Bean
使用`@Bean`注解将某一个类配置为容器，然后`Spring`运行时会自动扫描到，自动进行配置容器。通常放在`@Configuration`下面，当然没有`@Configuration`也可以正常运行，只是为了规范最好一起使用。<br />需要在配置类中添加`@Bean`方法，需要`Spring`管理的对象越多，则需要添加的`@Bean`方法就越多，虽然每个方法的代码并不复杂，但是当方法的数量到一定程度后比较繁琐，不易于股那里，这种做法的优点就是完全自定义对象的创建过程，在`@Bean`内部仍是传统的创建对象的语句。
<a name="ThAcY"></a>
### 组件扫描
`Spring`运行时通过`@ComponentScan("cdu.zch.spring")`组件扫描扫描组件类，然后组件类的`@Component`将自己声明为一个组件，供后续使用。只需要配置1次组件扫描，然后个组件类提添加组件注解即可，且各组件类添加组件注解后可以增强语义，所以，无论编码成本还是代码的可读性都好，这种做法的不足在于“只能适用于自定义的类”，毕竟你不可以在引用的库中的类上添加组件注解。
<a name="Gcm3v"></a>
# Spring Bean的作用域
在默认情况下，`SpringBean`的作用域是**单例**的。单例的表现为：实例唯一，即在任意时刻每个类的对象最多只有一个，并且，当对象创建出来之后，将常驻内存，直至Spring将其销毁（通常是`ApplicationContext`调用了销毁方法，或程序运行结束）。<br />验证单例：（`springBasic-03`）<br />文件目录和`springBasic-02`一样的。只是在`SpringRunner`中一点改变：
```java
package cdu.zch.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserMapper userMapper1 = (UserMapper) ac.getBean("userMapper");
        UserMapper userMapper2 = (UserMapper) ac.getBean("userMapper");
        UserMapper userMapper3 = (UserMapper) ac.getBean("userMapper");


        System.out.println(userMapper1);
        System.out.println(userMapper2);
        System.out.println(userMapper3);

        ac.close();
    }
}

```
输出：
```java
cdu.zch.spring.UserMapper@8b96fde
cdu.zch.spring.UserMapper@8b96fde
cdu.zch.spring.UserMapper@8b96fde
```
可见，三个实例对象输出的都是一样的，所以`SpringBean`的作用域都是单例。
<a name="IBkf2"></a>
## 可以通过`@Scope`修改作用域
如果通过`@Bean`创建对象，将`@Scope`添加到声明前。<br />如果通过组件扫描创建对象，将`@Scope`添加到声明前。
```java
@Scope("prototype")
@Bean

/**
@Scope("prototype")
@Component
*/
```
`@Scope`注解的常见取值：

- `singleton`：单例的，默认值。单例的`SpringBean`是预加载的，必要的话，可以改成懒加载的。预加载的表现为：加载`Spring`环境时就会创建对象，即加载`Spring`配置的环节。懒加载则是：在第一次获取对象的那一刻再创建对象。
- `prototype`：原型，非单例的

配置为懒加载：加`@Lazy`注解。`@Lazy`的值有`true`和`false`两种。
<a name="PwS2R"></a>
## 预加载和懒加载
<a name="X643M"></a>
### 预加载
优点在于，事先创建好对象，无论何时需要获取对象，都可以直接获取，缺点在于：相当于启动程序时就会创建对象，这样的对象越多，启动过程就越慢，并且，如果某个对象创建出来以后，在接下来很长一段时间都不需要使用，而此对象一直存在于内存中，则是一种浪费。
<a name="QRUo0"></a>
### 懒加载
优点在于，仅当需要对像时才会创建对象，不会形成对象，缺点在于：如果当前系统已经符合较重，需要的对象仍未加载，则会增加系统负担。<br />相比而言，开发中通常认为预加载是更合理的配置。
<a name="Wkpgl"></a>
# 自动装配
机制表现为：当某个量需要被赋值时，可以使用特定的语法，使得`Spring`尝试从容器中找到合适的值，并自动完成赋值。<br />最典型的表现就是在类的属性上添加`@Autowired`注解，`Spring`就会尝试从容器中找到合适的值为这个属性赋值。<br />创建`Maven`工程（`springBasic-04`）。<br />`SpringConfig`
```java
package cdu.zch.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cdu.zch.spring")
public class SpringConfig {
}
```
`UserMapper`
```java
package cdu.zch.spring;

import org.springframework.stereotype.Repository;

@Repository
public class UserMapper {

    public void insert(){
        System.out.println("UserMapper ----> UserMapper.insert()");
    }
}
```
`UserController`
```java
package cdu.zch.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    public void reg(){
        System.out.println("UserController.reg()");
        userMapper.insert();
    }

}
```
`SpringRunner`
```java
package cdu.zch.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserController userController = (UserController) ac.getBean("userController");

        System.out.println(userController);
        userController.reg();

        ac.close();
    }

}
```
输出：
```java
cdu.zch.spring.UserController@123f1134
UserController.reg()
UserMapper ----> UserMapper.insert()
```
