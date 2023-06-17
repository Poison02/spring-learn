package cdu.zch.spring6.test;

import cdu.zch.spring6.bean.SpringBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zch
 * @data 2023/6/17
 **/
public class SpringBeanTest {

    @Test
    public void testBean() {
        /*
        1. Spring默认情况下是如何管理bean的？
            默认情况下，bean是单例的
            在Spring上下文初始化的时候实例化
            在每一个调用该getBean的时候，都返回那个单例的对象
         2. 当将bean的scope属性设置为prototype：
            bean是多例的
            Spring上下文初始化的时候，不会初始化bean
            在每一个调用getBean的时候实例化bean

         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);

    }

    @Test
    public void testThreadScope() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);

//        启动一个新线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                SpringBean sb1 = applicationContext.getBean("sb", SpringBean.class);
                System.out.println(sb1);
            }
        }).start();
    }

}
