package cdu.zch.userservice;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author Zch
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"cdu.zch.userservice.feign"}) // 开启Feign客户端
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    /*
    Feign日志处理 日志级别为FULL，全部打印
     */
    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }

}
