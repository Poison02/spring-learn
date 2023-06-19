package cdu.zch.spring6.test;

import cdu.zch.spring6.bean.Husband;
import cdu.zch.spring6.bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zch
 * @data 2023/6/19
 **/
public class CircularDependencyTest {

    @Test
    public void testCD() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println(husband);
        System.out.println(wife);
    }

    @Test
    public void testCD2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        Husband husband = applicationContext.getBean("husbandBean", Husband.class);
        Wife wife = applicationContext.getBean("wifeBean", Wife.class);
        System.out.println(husband);
        System.out.println(wife);
    }

}
