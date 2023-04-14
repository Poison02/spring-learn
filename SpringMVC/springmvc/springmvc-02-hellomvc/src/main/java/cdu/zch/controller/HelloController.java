package cdu.zch.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Zch
 **/
public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView mv = new ModelAndView();
        // 业务

        String res = "Hello, SpringMVC";

        mv.addObject("msg", res);

        // 视图跳转
        mv.setViewName("test");
        return mv;
    }
}
