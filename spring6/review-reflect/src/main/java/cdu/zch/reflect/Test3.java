package cdu.zch.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author Zch
 * @data 2023/6/19
 **/
public class Test3 {

    public static void main(String[] args) throws Exception{
        // 获取类
        Class<?> clazz = Class.forName("cdu.zch.reflect.SomeService");
        // 获取方法
        Method doSome = clazz.getDeclaredMethod("doSome");
        // 创建对象
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object o = constructor.newInstance();
//        Object obj = clazz.newInstance();
        // 调用方法
        doSome.invoke(o);
    }

}
