package cdu.zch.annotation;

import cdu.zch.bean.Order;
import cdu.zch.bean.Student;
import cdu.zch.bean.User;
import cdu.zch.bean.Vip;
import cdu.zch.bean3.MyDataSource;
import cdu.zch.dao.OrderDao;
import cdu.zch.service.impl.OrderServiceImpl;
import cn.zch.Spring6Config;
import cn.zch.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zch
 * @data 2023/6/24
 **/
public class IoCAnnotationTest {

    @Test
    public void testBeanComponent() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
        Vip vipBean = applicationContext.getBean("vipBean", Vip.class);
        System.out.println(vipBean);
        Order order = applicationContext.getBean("order", Order.class);
        System.out.println(order);
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
        OrderDao orderDao = applicationContext.getBean("orderDao", OrderDao.class);
        System.out.println(orderDao);
    }

    @Test
    public void testChoose() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-choose.xml");

    }

    @Test
    public void testDIByAnnotation() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-di-annotation.xml");
        MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);
        cdu.zch.bean3.User user = applicationContext.getBean("user", cdu.zch.bean3.User.class);
        System.out.println(user);

    }

    @Test
    public void testAutowired() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowired.xml");
        OrderServiceImpl orderServiceImpl = applicationContext.getBean("orderServiceImpl", OrderServiceImpl.class);
        orderServiceImpl.generate();

    }

    @Test
    public void testResource() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-di-resource.xml");
        StudentServiceImpl studentServiceImpl = applicationContext.getBean("studentServiceImpl", StudentServiceImpl.class);
        studentServiceImpl.generate();

    }

    @Test
    public void testNoXml() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        StudentServiceImpl studentServiceImpl = applicationContext.getBean("studentServiceImpl", StudentServiceImpl.class);
        studentServiceImpl.generate();

    }

}
