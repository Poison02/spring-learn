package cdu.zch.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Zch
 * @date 2023/7/4
 **/
@FeignClient(value = "user-service")
public interface TestFeign {

    @GetMapping("/info")
    public String info();

}
