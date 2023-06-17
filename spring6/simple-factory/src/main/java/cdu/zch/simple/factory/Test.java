package cdu.zch.simple.factory;

/**
 * 客户端程序
 * @author Zch
 * @data 2023/6/17
 **/
public class Test {

    public static void main(String[] args) {
        // tank
        // 对于客户端来说，只需要向工厂索要即可
        // 简单工厂模式达到了什么？职责分离，客户端不用关系生产细节
        // 客户端只需要负责消费。工厂类负责生产。一个负责生产，一个负责消费。生产者和消费者分离了。这就是简单工厂模式的作用。
        Weapon tank = WeaponFactory.get("TANK");
        tank.attack();
        // dagger
        Weapon dagger = WeaponFactory.get("DAGGER");
        dagger.attack();
        // fighter
        Weapon fighter = WeaponFactory.get("FIGHTER");
        fighter.attack();
    }

}
