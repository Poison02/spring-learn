package cdu.zch.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

public class SpringRunner {

    public static void main(String[] args) {
        // 1、让Spring跑起来
        /**
         * AnnotationConfigApplicationContext : 用于加载Spring配置，同时是Spring容器
         *
         * 注意：需要在构造方法中添加参数
         * */
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringBeanFactory.class);

        // 2、从Spring中获取对象
        /**
         * 默认的bean name 就是 @Bean 方法的名称，返回值为 Object
         * 还可以传入类型 ac.getBean(Random.class); 但是当两种相同类型不同方法名时会出错
         * 或者既传名字，又可传类型，本质使根据名称获取，这种方法不用转类型 ac.getBean("random", Random.class);
         * */
        Random random = (Random) ac.getBean("random");

        // 3、测试使用
        System.out.println(random);

        // 4、结束
        ac.close();
    }

}
