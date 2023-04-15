package cdu.zch;

import cdu.zch.entity.Hello;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zch
 **/
public class HelloTest {
    @Test
    public void test() {
        // 读取配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello hello = (Hello) context.getBean("hello");
        hello.show();
    }
}
