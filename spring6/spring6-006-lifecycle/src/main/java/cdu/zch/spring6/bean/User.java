package cdu.zch.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @author Zch
 * @data 2023/6/19
 **/
public class User implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware, InitializingBean, DisposableBean {

    /*
    Bean的生命周期按照粗略的五步：
        1. 实例化Bean 调用无参构造方法
        2. 给Bean属性赋值 调用set方法
        3. 初始化Bean 调用Bean的init方法，但是这个init需要自己写
        4. 使用Bean
        5. 销毁Bean 调用destroy方法，但是需要自己写方法
     */

    private String name;

    public User() {
        System.out.println("第一步：实例化Bean");
    }

    public void setName(String name) {
        System.out.println("第二步：赋值...");
        this.name = name;
    }

    public void initBean() {
        System.out.println("第六步：初始化Bean...");
    }

    public void destroyBean() {
        System.out.println("第十步：销毁Bean...");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("第三步：类的classLoader是：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("第三步：类的beanFactory是：" + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("第三步：类的name是：" + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("第五步：执行afterPropertiesSet()...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("第九步：destroy()...");
    }
}
