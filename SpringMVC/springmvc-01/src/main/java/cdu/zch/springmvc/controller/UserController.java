package cdu.zch.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    // http://localhost:8080/hello.do
    // RequestMapping 用于配置【请求路径】与【处理请求的方法】的映射关系
    // ResponseBody 用于将方法的返回值以【相应正文】的方式相应到客户端
    // 注意：在Spring MVC框架中，默认响应的字符串正文并不支持中文
    @RequestMapping("/hello.do")
    @ResponseBody
    public String hello(){
        return "hello, SpringMVC!!!";
    }

}
