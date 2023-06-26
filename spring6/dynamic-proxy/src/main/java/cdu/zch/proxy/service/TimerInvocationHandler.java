package cdu.zch.proxy.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 专门负责计时的一个调用处理器对象。
 * 在这个调用处理器中编写计时相关的增强代码
 * 只需要写一次就行了
 * @author Zch
 * @date 2023/6/26
 **/
public class TimerInvocationHandler implements InvocationHandler {

    // 目标对象
    private Object target;

    public TimerInvocationHandler(Object target) {
        this.target = target;
    }

    /*
    1. 为什么强行要求必须实现InvocationHandler接口？
        因为一个类实现接口就必须实现接口中的方法
        以下这个方法必须是invoke()，因为jdk在底层已经写好了
        注意：invoke不是我们调用的，而是jdk调用
    2. invoke()什么时候调用？
        当代理对象调用代理方法的时候，注册在InvocationHandler调用处理器当中的invoke()会被jdk调用
    3. invoke 的三个参数
        invoke方法是JDK负责调用的，调用的时候JDK自动传过来
        Object proxy 代理对象的引用
        Method method 目标对象的目标方法，就是要使用它！
        Object[] args 目标方法的实参
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 这个接口的目的就是为了写增强代码
//        System.out.println("增强方法1");
        long begin = System.currentTimeMillis();
        // 调用目标对象的目标方法
        // 方法四要素：哪个对象、哪个方法、传什么参数、返回什么
        Object retValue = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println("执行了" + (end - begin)+ "毫秒");
//        System.out.println("增强方法2");
        // 注意这个invoke方法的返回值，如果代理对象调用代理方法之后需要返回结果的话，这里也需要返回！
        return retValue;
    }
}
