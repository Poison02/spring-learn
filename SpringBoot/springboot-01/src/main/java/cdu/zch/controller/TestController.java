package cdu.zch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * @author Zch
 **/
@Controller
public class TestController {

    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("msg", Arrays.asList("Hello", "olleH"));
        return "test";
    }
}
