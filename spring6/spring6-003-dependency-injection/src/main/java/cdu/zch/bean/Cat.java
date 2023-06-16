package cdu.zch.bean;

/**
 * @author Zch
 * @data 2023/6/16
 **/
public class Cat {

    private String name;

    private int age;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
