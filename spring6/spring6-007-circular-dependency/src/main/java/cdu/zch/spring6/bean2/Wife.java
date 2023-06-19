package cdu.zch.spring6.bean2;

/**
 * @author Zch
 * @data 2023/6/19
 **/
public class Wife {

    private String name;

    private Husband husband;

    public Wife(String name, Husband husband) {
        this.name = name;
        this.husband = husband;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                ", husband=" + husband.getName() +
                '}';
    }
}
