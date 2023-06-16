package cdu.zch.bean;

import java.util.Date;

/**
 * @author Zch
 * @data 2023/6/16
 **/
public class Dog {

    // 测试 p 命名空间注入
    /*
    p 命名空间本质还是set注入
     */
    private String name;
    private int age;
    private Date birth;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
