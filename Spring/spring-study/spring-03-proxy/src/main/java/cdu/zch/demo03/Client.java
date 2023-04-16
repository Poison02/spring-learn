package cdu.zch.demo03;

import cdu.zch.demo02.UserService;
import cdu.zch.demo02.UserServiceImpl;

/**
 * @author Zch
 **/
public class Client {

    public static void main(String[] args) {
        // 代理角色，是不存在的！
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        proxyInvocationHandler.setTarget(new UserServiceImpl());

        // 动态生成代理类
        UserService proxy = (UserService) proxyInvocationHandler.getProxy();

        proxy.add();
        proxy.update();
        proxy.delete();
        proxy.query();
    }

}
