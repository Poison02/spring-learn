package cdu.zch.customerservice.feign;

import cdu.zch.customerservice.feign.hystrix.CustomerRentFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Zch
 * @date 2023/6/29
 **/
// 这里加fallback意思是，服务宕机之后的备选方案
@FeignClient(value = "rentcar-service", path = "/customerRent", fallback = CustomerRentFeignHystrix.class)
public interface CustomerRentFeign {

    @GetMapping("/rent")
    public String rent();

}
