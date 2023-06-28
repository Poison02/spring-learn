package cdu.zch.spring6;

import cdu.zch.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zch
 * @date 2023/6/28
 **/
public class SMTest {

    @Test
    public void testSM() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("act_001", "act_002", 10000D);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
