package cdu.zch.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserController userController = (UserController) ac.getBean("userController");

        System.out.println(userController);
        userController.reg();

        ac.close();
    }

}
