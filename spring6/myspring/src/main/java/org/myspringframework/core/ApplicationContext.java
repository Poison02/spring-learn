package org.myspringframework.core;

/**
 * Spring应用上下文
 * @author Zch
 * @data 2023/6/23
 **/
public interface ApplicationContext {

    /**
     * 根据Bean名称获取Bean对象
     * @param beanName 配置文件中bean id
     * @return bean对象
     */
    default Object getBean(String beanName) {
        return null;
    }

}
