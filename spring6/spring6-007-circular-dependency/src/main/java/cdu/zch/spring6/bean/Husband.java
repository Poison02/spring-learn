package cdu.zch.spring6.bean;

/**
 * @author Zch
 * @data 2023/6/19
 **/
public class Husband {

    private String name;

    private Wife wife;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        return "Husband{" +
                "name='" + name + '\'' +
                ", wife=" + wife.getName() +
                '}';
    }
}
