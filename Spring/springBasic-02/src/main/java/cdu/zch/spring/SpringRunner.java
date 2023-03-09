package cdu.zch.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringRunner {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserMapper userMapper = ac.getBean(UserMapper.class);

        System.out.println(userMapper);

        ac.close();

    }

}
