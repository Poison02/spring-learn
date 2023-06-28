package cdu.zch.bank;

import cdu.zch.bank.pojo.Account;
import cdu.zch.bank.service.AccountService;
import cdu.zch.bank.service.IsolationService1;
import cdu.zch.bank.service.IsolationService2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author Zch
 * @date 2023/6/28
 **/
public class BankTest {

    @Test
    public void testTransfer(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("act_001", "act_002", 10000D);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testPropagation() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);

        Account act1 = new Account("act_003", 30000D);
        accountService.save(act1);
    }

    @Test
    public void testIsolation1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService1 i1 = applicationContext.getBean("i1", IsolationService1.class);
        i1.getByActno("act_004");
    }

    @Test
    public void testIsolation2() throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService2 i2 = applicationContext.getBean("i2", IsolationService2.class);
        Account act = new Account("act_004", 30000D);
        i2.save(act);
    }

    @Test
    public void testNoXML() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("act_001", "act_002", 10000D);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
