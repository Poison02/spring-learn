package cdu.zch.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Zch
 **/
public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理的接口对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    // 生成代理对象
    public Object getProxy() {
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }

    // 处理代理实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 这里调用日志功能，利用反射获得方法名字
        log(method.getName());
        Object result = method.invoke(target, args);
        return result;
    }

    // 如果要加上日志实现，只需要这里写了 然后invoke方法里面调用即可
    public void log(String msg) {
        System.out.println("[DEBUG] 实现了" + msg + "功能");
    }
}
