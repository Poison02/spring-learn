package cdu.zch.demo01;

/**
 * @author Zch
 **/
public class Client {

    public static void main(String[] args) {
        Host host = new Host();

        Proxy proxy = new Proxy(host);

        proxy.sale();
    }
}
