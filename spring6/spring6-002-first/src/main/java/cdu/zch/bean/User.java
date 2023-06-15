package cdu.zch.bean;

/**
 * 这是一个bean，封装用户信息，spring可以帮助我们创建user对象吗？
 * @author Zch
 * @data 2023/6/15
 **/
public class User {

    /*
    Spring是怎么实例化对象的？
    默认情况下Spring会通过反射机制，调用类的无参构造方法实例化对象
    实现原理如下：
    Class clazz = Class.forName("cdu.zch.bean.User");
    Object obj = clazz.newInstance();
     */
    public User() {
        System.out.println("无参方法执行");
    }


}
