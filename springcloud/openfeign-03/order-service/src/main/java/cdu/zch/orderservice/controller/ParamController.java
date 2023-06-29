package cdu.zch.orderservice.controller;

import cdu.zch.orderservice.doMain.Order;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author Zch
 * @date 2023/6/29
 **/
@RestController
public class ParamController {

    // 主要用于传递参数的处理
    /*
    url：/doOrder/aaa/add/bbb
    get: 传一个参数
    get传多个参数
    post传一个对象
    post传一个对象 + 一个基本参数
     */
    @GetMapping("/testUrl/{name}/and/{age}")
    public String testUrl(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        System.out.println(name + " " + age);
        return "OK";
    }

    @GetMapping("/oneParam")
    public String oneParam(@RequestParam(required = false) String name) {
        System.out.println(name);
        return "OK";
    }

    @GetMapping("/twoParam")
    public String twoParam(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
        System.out.println(name + " " + age);
        return "OK";
    }

    @PostMapping("/oneObj")
    public String oneObj(@RequestBody Order order) {
        System.out.println(order);
        return "OK";
    }

    @PostMapping("/oneObjOneParam")
    public String oneObjOneParam(@RequestBody Order order, @RequestParam(required = false) String name) {
        System.out.println(order + " " + name);
        return "OK";
    }

}
