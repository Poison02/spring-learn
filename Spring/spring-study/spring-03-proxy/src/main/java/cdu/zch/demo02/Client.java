package cdu.zch.demo02;

/**
 * @author Zch
 **/
public class Client {

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.setUserService(new UserServiceImpl());

        proxy.add();
        proxy.update();
        proxy.delete();
        proxy.query();
    }

}
