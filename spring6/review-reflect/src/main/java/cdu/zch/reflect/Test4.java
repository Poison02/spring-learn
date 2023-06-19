package cdu.zch.reflect;

import java.lang.reflect.Method;

/**
 * @author Zch
 * @data 2023/6/19
 **/
public class Test4 {

    public static void main(String[] args) throws Exception{
        // 已知类名
        String className = "cdu.zch.reflect.User";
        // 已知属性名
        String propertyName = "age";

        // 通过反射机制给User对象的age属性赋值20岁
        Class<?> clazz = Class.forName(className);
        Object obj = clazz.newInstance(); // 创建对象

        // 根据属性名获取setter方法名
        String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);

        // 获取Method
        Method setMethod = clazz.getDeclaredMethod(setMethodName, int.class);

        // 调用Method
        setMethod.invoke(obj, 20);

        System.out.println(obj);
    }

}
