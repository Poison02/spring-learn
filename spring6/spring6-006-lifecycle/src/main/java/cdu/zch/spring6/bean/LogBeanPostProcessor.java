package cdu.zch.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 日志Bean后处理器
 * @author Zch
 * @data 2023/6/19
 **/
public class LogBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第四步：指定Bean后处理器的before方法");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    /**
     * 方法有两个参数
     * @param bean 刚创建的bean对象
     * @param beanName bean名字
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第七步：指定Bean后处理器的after方法");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
