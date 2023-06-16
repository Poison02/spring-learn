package cdu.zch.bean;

/**
 * @author Zch
 * @data 2023/6/16
 **/
public class Clazz {

    // 班级名称
    private String name;

    @Override
    public String toString() {
        return "Clazz{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
