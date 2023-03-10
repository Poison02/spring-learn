<a name="HJGJV"></a>
# 关于SpringMVC框架
- `SpringMVC`是基于`Spring`框架基础之上的，主要解决了后端服务器接收客户端提交的请求，并给予响应的相关问题。
- MVC = Model + View + Controller，它们分别是：
   - Model：数据模型，通常由业务逻辑层（Service Layer）和数据访问层（Data Access Object Layer）共同构成
   - View：视图
   - Controller：控制器
   - MVC为项目中代码的职责划分提供了参考
- 需要注意：`SpringMVC`框架只关心V-C之间的交互，与M没有任何关系。
<a name="PUPg1"></a>
# SpringMVC第一个Demo
创建一个新的`Maven`工程（`springmvc-01`）。<br />在`pom.xml`中引入相应的依赖：
```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-webmvc</artifactId>
  <version>5.3.18</version>
</dependency>

<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>javax.servlet-api</artifactId>
  <version>4.0.1</version>
  <scope>provided</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-context</artifactId>
  <version>5.3.18</version>
</dependency>
```
创建`cdu.zch.springmvc.config.SpringConfig`和`cdu.zch.springmvc.config.SpringMVCConfig`<br />`SpringConfig`中：
```java
package cdu.zch.springmvc.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
}
```
`SpringMVCConfig`：
```java
package cdu.zch.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("cdu.zch.springmvc")
public class SpringMVCConfig implements WebMvcConfigurer {
}
```
然后创建`cdu.zch.springmvc.SpringMVCInitializer`
```java
package cdu.zch.springmvc;

import cdu.zch.springmvc.config.SpringConfig;
import cdu.zch.springmvc.config.SpringMVCConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // Spring 配置类
        return new Class[] {SpringConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // SpringMVC 配置类
        return new Class[]{SpringMVCConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // 返回Spring MVC框架处理的请求的路径
        // http://localhost:8080/index.do 按照SpringMVC的流程执行
        // http://localhost:8080/index.jpg 不按照SpringMVC的流程执行
        return new String[] {"*.do"};
    }
}
```
最后创建`cdu.zch.springmvc.controller.UserController`
```java
package cdu.zch.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    // http://localhost:8080/hello.do
    // RequestMapping 用于配置【请求路径】与【处理请求的方法】的映射关系
    // ResponseBody 用于将方法的返回值以【相应正文】的方式相应到客户端
    // 注意：在Spring MVC框架中，默认响应的字符串正文并不支持中文
    @RequestMapping("/hello.do")
    @ResponseBody
    public String hello(){
        return "hello, SpringMVC!!!";
    }

}
```
补充：Tomcat的配置<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/35204765/1678461045702-e9a60660-3e4c-491d-85bc-cae5fe017cb3.png#averageHue=%233e4245&clientId=u387c2df7-b85a-4&from=paste&height=714&id=u2eff2670&name=image.png&originHeight=714&originWidth=1035&originalType=binary&ratio=1&rotation=0&showTitle=false&size=74802&status=done&style=none&taskId=u091c3bc4-aa2b-4e98-adeb-c17f8b9e1f5&title=&width=1035)<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/35204765/1678461049324-9814bb01-0501-42d1-8031-27e443a5236c.png#averageHue=%233c4044&clientId=u387c2df7-b85a-4&from=paste&height=715&id=u9426fdaf&name=image.png&originHeight=715&originWidth=1046&originalType=binary&ratio=1&rotation=0&showTitle=false&size=42182&status=done&style=none&taskId=u9cc604d9-97ba-4c0c-8edc-7febf5cddb4&title=&width=1046)<br />最后运行Tomcat，然后浏览器访问`http://localhost:8080/hello.do`<br />即可看到输出`hello,SpringMVC!!!`<br />至此，第一个`SpringMVC`的Demo结束。
