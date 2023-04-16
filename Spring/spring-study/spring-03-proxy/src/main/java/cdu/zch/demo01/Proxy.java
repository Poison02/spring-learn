package cdu.zch.demo01;

/**
 * @author Zch
 **/
public class Proxy implements Rent{

    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void sale() {
        seeHouse();
        host.house();
        house();
        money();
    }

    public void money() {
        System.out.println("收取中介费");
    }

    public void seeHouse() {
        System.out.println("看房");
    }

    @Override
    public void house() {
        System.out.println("房东出租房子，但是我这里是中介");
    }
}
