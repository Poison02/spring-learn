package cdu.zch.factory.mathod;

/**
 * @author Zch
 * @data 2023/6/17
 **/
public class Test {

    public static void main(String[] args) {
        WeaponFactory weaponFactory = new DaggerFactory();
        Weapon dagger = weaponFactory.get();
        dagger.attack();
        WeaponFactory weaponFactory1 = new GunFactory();
        Weapon gun = weaponFactory1.get();
        gun.attack();
    }

}
