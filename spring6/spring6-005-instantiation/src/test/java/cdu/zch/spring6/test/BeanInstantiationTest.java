package cdu.zch.spring6.test;

import cdu.zch.spring6.bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zch
 * @data 2023/6/18
 **/
public class BeanInstantiationTest {

    // 调用无参构造方法
    @Test
    public void testInstantiation1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
        SpringBean springBean = applicationContext.getBean("springBean", SpringBean.class);
        System.out.println(springBean);
    }

    // 通过简单工厂模式
    @Test
    public void testInstantiation2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
        Star starBean = applicationContext.getBean("starBean", Star.class);
        System.out.println(starBean);
    }

    // 通过工厂方法模式
    @Test
    public void testInstantiation3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
        Gun gun = applicationContext.getBean("gun", Gun.class);
        System.out.println(gun);
    }

    // 通过FactoryBean
    @Test
    public void testInstantiation4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void testDate() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
    }

}
