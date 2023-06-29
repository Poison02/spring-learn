package cdu.zch.customerservice.controller;

import cdu.zch.customerservice.feign.CustomerRentFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Zch
 * @date 2023/6/29
 **/
@RestController
public class CustomerController {

    @Resource
    private CustomerRentFeign customerRentFeign;

    @GetMapping("/customerRent")
    public String customerRent() {
        customerRentFeign.rent();
        return "租车成功！";
    }

}
