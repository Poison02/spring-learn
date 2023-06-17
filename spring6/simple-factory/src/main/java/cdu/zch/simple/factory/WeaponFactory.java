package cdu.zch.simple.factory;

/**
 * 工厂类角色
 * @author Zch
 * @data 2023/6/17
 **/
public class WeaponFactory {

    /**
     * 静态方法。要获取什么产品？看你传的参数，传TANK，FIGHTER，DAGGER
     * 简单工厂模式有一个静态方法，所以被称为静态工厂方法模式
     * @param weaponType 武器类型 TANK、FIGHTER、DAGGER
     * @return Object
     */
    public static Weapon get(String weaponType) {
        if ("TANK".equals(weaponType)) {
            return new Tank();
        } else if ("FIGHTER". equals(weaponType)) {
            return new Fighter();
        } else if ("DAGGER". equals(weaponType)) {
            return new Dagger();
        } else {
            throw new RuntimeException("不支持的武器");
        }
    }

}
