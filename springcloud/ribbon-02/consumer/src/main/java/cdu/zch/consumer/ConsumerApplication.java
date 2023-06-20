package cdu.zch.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author 20698
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    /*
    这个RestTemplate已经变了，加了 @LoadBalanced 这个注解，将交给ribbon操作
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate () {
        return new RestTemplate();
    }

}
