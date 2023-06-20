package cdu.zch.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Zch
 * @data 2023/6/19
 **/
@RestController
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;

    // 就可以在Java代码中发起http请求了
    // RestFul 就使用RestTemplate
    // 服务发现 通过服务的应用名称找到服务的具体实例
    @GetMapping("/test")
    public String doDiscovery(String serverName) {
        // 通过服务的应用名称找到服务的具体信息
        List<ServiceInstance> instances = discoveryClient.getInstances(serverName);
        //
        instances.forEach(System.out::println);

        ServiceInstance serviceInstance = instances.get(0);
        String ip = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        System.out.println(ip + ":" + port);

        // 这里去找另一个客户端按的ip和port
        return instances.get(0).toString();
    }

}
