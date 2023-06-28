package cdu.zch.spring6;

import cdu.zch.spring6.bean.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author Zch
 * @date 2023/6/28
 **/
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring.xml")
public class SpringJunit5Test {

    @Autowired
    private User user;

    @Test
    public void testUser() {
        System.out.println(user);
    }

}
