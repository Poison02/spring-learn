package cdu.zch.spring6;

import cdu.zch.spring6.bean.Student;
import cdu.zch.spring6.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zch
 * @data 2023/6/19
 **/
public class BeanLifeCycleTest {

    /*
    Spring容器只对singleton的Bean进行完整的生命周期管理
    如果是prototype作用域的Bean，Spring容器只负责将改Bean初始化完毕。等客户端程序一旦获取到Bean，Spring容器就不再管理该对象的生命周期
     */
    @Test
    public void testLifeCycle() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("第八步：使用Bean..." + user);
        // 手动关闭Spring容器，这样Spring才会销毁Bean
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();
    }

    /*
    自己new对象如何给Spring容器管理
     */
    @Test
    public void testRegisterBean() {
        Student student = new Student();
        System.out.println(student);

        // 将上面的对象交给Spring管理
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerSingleton("studentBean", student);
        // 从Spring容器中获取
        Object studentBean = defaultListableBeanFactory.getBean("studentBean");
        System.out.println(studentBean);
    }

}
