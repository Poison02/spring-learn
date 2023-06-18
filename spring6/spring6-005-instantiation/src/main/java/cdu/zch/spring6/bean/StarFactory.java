package cdu.zch.spring6.bean;

/**
 * 简单工厂模式中的工厂类角色
 * @author Zch
 * @data 2023/6/18
 **/
public class StarFactory {

    // 工厂类中有一个静态方法
    public static Star get() {
        // 这个Star对象实际上还是我们自己new的
        return new Star();
    }

}
