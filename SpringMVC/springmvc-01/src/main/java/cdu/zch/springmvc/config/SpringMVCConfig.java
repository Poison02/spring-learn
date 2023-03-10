package cdu.zch.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("cdu.zch.springmvc")
public class SpringMVCConfig implements WebMvcConfigurer {
}
