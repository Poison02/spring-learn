package cdu.zch.controller;

import cdu.zch.feign.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Zch
 * @date 2023/7/4
 **/
@RestController
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private TestFeign testFeign;

    @GetMapping("/test")
    public String test() {
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        System.out.println(instances);
        return testFeign.info();
    }

}
