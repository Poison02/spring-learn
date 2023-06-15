package cdu.zch.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author Zch
 * @data 2023/6/15
 **/

public class FirstSpringTest {

    @Test
    public void testFirstSpringCode() {
        // 1. 获取Spring容器对象
        /*
        ApplicationContext：应用上下文，就是Spring容器
        是一个接口
        接口下有很多类，其中有一个实现类 ClassPathXmlApplicationContext
        ClassPathXmlApplicationContext：专门从根路径下加载Spring配置文件的一个Spring上下文对象。
        这行代码只要执行，就相当于启动了Spring容器，解析spring.xml文件，并且实例化所有的bean，放到Spring容器中
         */
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml", "spring2.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml", "spring2.xml", "/xml/spring3.xml");
        // 2. 根据bean的id从Spring容器中获取这个对象
        Object userBean = applicationContext.getBean("userBean");
//        Object userDaoImplBean = applicationContext.getBean("userDaoImplBean");
        System.out.println(userBean);
//        System.out.println(userDaoImplBean);

        Object userBean2 = applicationContext.getBean("userBean2");
        System.out.println(userBean2);

        Object userBean3 = applicationContext.getBean("userBean3");
        System.out.println(userBean3);

        Object nowTime = applicationContext.getBean("nowTime");
        // 如果bean的id不存在，不会返回null，而是出现异常
//        Object nowTime2 = applicationContext.getBean("nowTime2");
        // 不想强制类型转换：需要指定第二个参数
        Date nowTime2 = applicationContext.getBean("nowTime", Date.class);
        System.out.println(nowTime);
    }

    @Test
    public void testBeanFactory() {
        /*
        ApplicationContext接口的超级父接口是：BeanFactory，Bean工厂，就是能够生产Bean对象的一个工厂
        BeanFactory 是IoC容器的顶级接口
        Spring的IoC容器底层实际上使用了工厂模式
        Spring底层的IoC是怎么实现？XML解析 + 工厂模式 + 反射机制
        所以使用 BeanFactory applicationContext2 = new ClassPathXmlApplicationContext("spring.xml"); 也是完全没问题的
         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        BeanFactory applicationContext2 = new ClassPathXmlApplicationContext("spring.xml");
        applicationContext.getBean("userBean");
    }
    @Test
    public void testBeginInitBean() {
        // 注意不是在调用getBean()方法的时候创建对象，执行以下代码的时候就已经创建了对象了
        new ClassPathXmlApplicationContext("spring.xml");
        /*
        你自己怎么使用Log4j2记录日志信息呢？
        1. 创建日志记录器对象
        获取FirstSpringTest类的日志记录器对象，也就是说只要是FirstSpringTest类中的代码执行记录日志的话，就输出相关的信息
         */
        Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);
        // 2. 记录日志，根据不同的级别来输出日志
        logger.info("我是一条消息");
        logger.debug("我是一条debug消息");
        logger.error("我是一条error消息");
    }
}
