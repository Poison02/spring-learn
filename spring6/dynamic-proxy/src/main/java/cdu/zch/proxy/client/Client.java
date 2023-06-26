package cdu.zch.proxy.client;

import cdu.zch.proxy.service.OrderService;
import cdu.zch.proxy.service.OrderServiceImpl;
import cdu.zch.proxy.service.TimerInvocationHandler;
import cdu.zch.proxy.util.ProxyUtil;

import java.lang.reflect.Proxy;

/**
 * 客户端程序
 * @author Zch
 * @date 2023/6/26
 **/

public class Client {

    public static void main(String[] args) {
        // 创建目标对象
        OrderService target = new OrderServiceImpl();
        // 创建代理对象
        /*
        1. newProxyInstance 新建代理对象
            通过调用这个方法可以创建代理对象
            本质上，newProxyInstance方法的执行，做了两件事
                1. 在内存中动态的生成了一个代理类的字节码class
                2. new对象，同归哦内存中生成的代理类这个代码，实例化了代理对象
        2. 三个参数：
            ClassLoader loader：
                类加载器，在内存中生成的字节码也是class文件，要执行也得先加载到内存中。
                这里需要类加载器，并且必须和代理类的类加载器是同一个
            Class<?>[] interfaces：
                代理类和目标类要实现同一个或者同一些接口
                在内存中生成代理类的时候，这个代理类是需要你告诉它实现哪些接口的
            InvocationHandler h：调用处理器，是一个接口
                编写的就是：增强代码
                既然是接口，就要写接口的实现类
                这个接口实现类只需要写一次即可，不会类爆炸
        注意：代理对象和目标对象实现了接口，所以可以向下转型
         */
        /*OrderService proxyObj = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                                 target.getClass().getInterfaces(),
                                                 new TimerInvocationHandler(target));*/
        // 这里还可以使用封装的工具类
        OrderService proxyObj = (OrderService) ProxyUtil.newProxyInstance(target);
        // 调用代理对象的代理方法
        // 注意：调用代理对象的代理方法的时候，需要保证目标对象的目标方法需要执行
        proxyObj.generate();
        proxyObj.modify();
        proxyObj.detail();
        String name = proxyObj.getName();
        System.out.println(name);
    }

}
