package cdu.zch.customerservice.feign.hystrix;

import cdu.zch.customerservice.feign.CustomerRentFeign;
import org.springframework.stereotype.Component;

/**
 * @author Zch
 * @date 2023/6/29
 **/
@Component
public class CustomerRentFeignHystrix implements CustomerRentFeign {

    // 这个方法就是备选方案，熔断备选
    @Override
    public String rent() {
        return "另一个服务宕机咯，我是备胎~";
    }
}
