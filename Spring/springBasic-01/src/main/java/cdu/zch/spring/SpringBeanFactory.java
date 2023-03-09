package cdu.zch.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration // 不是必须的，但是规范是@Bean是写在@Configuration下面
public class SpringBeanFactory {


    @Bean // 使Spring自动调用此方法  可以 @Bean("bean name") 这里的名字对应getBean（bean name），默认不传则是方法名
    public Random random(){
        return new Random();
    }

}
