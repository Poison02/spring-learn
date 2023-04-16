package cdu.zch.demo02;

/**
 * @author Zch
 **/
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("使用了add方法");
    }

    @Override
    public void delete() {
        System.out.println("使用了delete方法");
    }

    @Override
    public void update() {
        System.out.println("使用了update方法");
    }

    @Override
    public void query() {
        System.out.println("使用了query方法");
    }
}
