package cdu.zch.rentcarservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RentcarServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentcarServiceApplication.class, args);
    }

}
