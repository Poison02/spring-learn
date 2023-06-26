package cdu.zch.proxy.util;

import cdu.zch.proxy.service.OrderService;
import cdu.zch.proxy.service.TimerInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @author Zch
 * @date 2023/6/26
 **/
public class ProxyUtil {

    /**
     * 封装一个工具方法，可任意通过这个方法调用，实现动态代理
     */
    public static Object newProxyInstance(Object target) {
        Object proxyObj = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                                 target.getClass().getInterfaces(),
                                                 new TimerInvocationHandler(target));
        return proxyObj;
    }

}
