package cdu.zch.spring6.bean2;

/**
 * @author Zch
 * @data 2023/6/19
 **/
public class Husband {

    private String name;

    private Wife wife;

    public Husband(String name, Wife wife) {
        this.name = name;
        this.wife = wife;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Husband{" +
                "name='" + name + '\'' +
                ", wife=" + wife.getName() +
                '}';
    }
}
