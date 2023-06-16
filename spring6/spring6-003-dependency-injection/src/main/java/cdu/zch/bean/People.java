package cdu.zch.bean;

/**
 * @author Zch
 * @data 2023/6/16
 **/
public class People {

    private String name;
    private int age;
    private boolean sex;

//    c命名空间是简化构造注入的
    public People(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
