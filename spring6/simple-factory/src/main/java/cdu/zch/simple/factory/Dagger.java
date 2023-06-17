package cdu.zch.simple.factory;

/**
 * 具体产品角色
 * @author Zch
 * @data 2023/6/17
 **/
public class Dagger extends Weapon{
    @Override
    public void attack() {
        System.out.println("Dagger 攻击");
    }
}
