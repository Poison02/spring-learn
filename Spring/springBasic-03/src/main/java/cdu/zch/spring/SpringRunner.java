package cdu.zch.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserMapper userMapper1 = (UserMapper) ac.getBean("userMapper");
        UserMapper userMapper2 = (UserMapper) ac.getBean("userMapper");
        UserMapper userMapper3 = (UserMapper) ac.getBean("userMapper");


        System.out.println(userMapper1);
        System.out.println(userMapper2);
        System.out.println(userMapper3);

        ac.close();
    }
}
