package cdu.zch.client;

import cdu.zch.annotation.Component;

/**
 * @author Zch
 * @data 2023/6/24
 **/
public class ReflectAnnotationTest1 {

    public static void main(String[] args) throws Exception{
        // 通过反射机制读取注解
        Class<?> clazz = Class.forName("cdu.zch.bean.User");
        // 判断类上面有没有这个注解
        if (clazz.isAnnotationPresent(Component.class)) {
            // 获取类上的注解
            Component annotation = clazz.getAnnotation(Component.class);
            // 访问注解属性
            System.out.println(annotation.value());
        }
    }

}
