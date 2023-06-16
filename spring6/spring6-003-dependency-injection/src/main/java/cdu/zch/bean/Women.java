package cdu.zch.bean;

/**
 * @author Zch
 * @data 2023/6/16
 **/
public class Women {
    private String name;

    @Override
    public String toString() {
        return "Women{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
