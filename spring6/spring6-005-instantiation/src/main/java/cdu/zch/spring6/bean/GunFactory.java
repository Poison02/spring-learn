package cdu.zch.spring6.bean;

/**
 * 工厂方法模式中的具体工厂角色
 * @author Zch
 * @data 2023/6/18
 **/
public class GunFactory {

    // 工厂方法模式中的具体工厂角色中的方法是：实例方法
    public Gun get() {
        // 实际上对象还是new的
        return new Gun();
    }

}
