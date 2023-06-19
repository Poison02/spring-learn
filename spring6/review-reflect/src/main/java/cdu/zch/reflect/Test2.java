package cdu.zch.reflect;

import java.lang.reflect.Method;

/**
 * @author Zch
 * @data 2023/6/19
 **/
public class Test2 {

    public static void main(String[] args) throws Exception{
        // 使用反射机制调用方法
        // 1. 获取类
        Class<?> clazz = Class.forName("cdu.zch.reflect.SomeService");
        // 2. 获取方法
        Method doSome = clazz.getDeclaredMethod("doSome", String.class, int.class);
        // 3. 调用方法
        // 四要素：哪个对象，哪个方法，传什么参数，返回什么
        // obj 要素，哪个对象
        // doSome 哪个方法
        // ”aaa“ 传参数
        // returnValue 返回
        Object obj = clazz.newInstance();
        Object returnValue = doSome.invoke(obj, "aaa", 111);
        System.out.println(returnValue);
    }

}
