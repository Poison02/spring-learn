package cdu.zch.spring6;

import cdu.zch.spring6.biz.UserService;
import cdu.zch.spring6.biz.VipService;
import cdu.zch.spring6.service.AccountService;
import cdu.zch.spring6.service.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zch
 * @date 2023/6/27
 **/
public class TransactionTest {

    @Test
    public void aopRealTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        accountService.transfer();
        accountService.withdraw();
        orderService.generate();
        orderService.cancel();
    }

    @Test
    public void aopRealTest2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        VipService vipService = applicationContext.getBean("vipService", VipService.class);
        userService.saveUser();
        userService.deleteUser();
        userService.updateUser();
        userService.selectUser();

        vipService.saveVip();
        vipService.deleteVip();
        vipService.updateVip();
        vipService.selectVip();
    }

}
