package cdu.zch.spring6;

import cdu.zch.spring6.service.OrderService;
import cdu.zch.spring6.service.Spring6Config;
import cdu.zch.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zch
 * @date 2023/6/27
 **/
public class AOPTest {

    @Test
    public void testBefore() {
        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        /*UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.login();
        userService.logout();*/

        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }

}
