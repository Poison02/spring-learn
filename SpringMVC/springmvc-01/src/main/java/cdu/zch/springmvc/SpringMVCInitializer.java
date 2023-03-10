package cdu.zch.springmvc;

import cdu.zch.springmvc.config.SpringConfig;
import cdu.zch.springmvc.config.SpringMVCConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // Spring 配置类
        return new Class[] {SpringConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // SpringMVC 配置类
        return new Class[]{SpringMVCConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // 返回Spring MVC框架处理的请求的路径
        // http://localhost:8080/index.do 按照SpringMVC的流程执行
        // http://localhost:8080/index.jpg 不按照SpringMVC的流程执行
        return new String[] {"*.do"};
    }
}
