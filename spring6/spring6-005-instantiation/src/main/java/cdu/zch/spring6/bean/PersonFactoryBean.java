package cdu.zch.spring6.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author Zch
 * @data 2023/6/18
 **/
// 这也是一个Bean，只不过是一个工厂Bean，通过这个特殊的Bean可以获取其一个普通Bean
public class PersonFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        // 最终这个Bean的创建还是手动new的
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    // 这个方法模式实现为单例
    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
