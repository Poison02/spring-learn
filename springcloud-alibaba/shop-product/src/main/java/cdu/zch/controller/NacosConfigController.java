package cdu.zch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zch
 * @date 2023/7/27
 **/
@RestController
@RefreshScope // 只需要在需要动态读取配置的类上添加此注解就可以
public class NacosConfigController {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @GetMapping("/test1")
    public String nacosConfingTest1() {
        return
                (applicationContext.getEnvironment().getProperty("config.appName")
                );
    }

    /*@Value( "${config.appName}" )
    private String appName;

    @GetMapping( "/test2" )
    public String nacosConfingTest2() {
        return (appName);
    }*/

    @Value( "${config.env}" )
    private String env;

    @GetMapping( "/test3" )
    public String nacosConfingTest3() {
        return (env);
    }

}
