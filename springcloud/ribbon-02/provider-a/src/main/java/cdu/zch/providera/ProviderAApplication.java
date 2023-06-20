package cdu.zch.providera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 20698
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderAApplication.class, args);
    }

}
