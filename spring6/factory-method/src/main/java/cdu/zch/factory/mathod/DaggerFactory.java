package cdu.zch.factory.mathod;

/**
 * @author Zch
 * @data 2023/6/17
 **/
public class DaggerFactory extends WeaponFactory{
    @Override
    public Weapon get() {
        return new Dagger();
    }
}
