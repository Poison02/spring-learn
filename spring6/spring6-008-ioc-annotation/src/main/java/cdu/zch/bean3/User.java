package cdu.zch.bean3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Zch
 * @data 2023/6/24
 **/
@Component
public class User {

    /*
    @Value注解可以用在属性、set方法、构造方法上
     */

//    @Value("小明")
//    private String name;
//
//    @Value("18")
//    private int age;

    private String name;
    private int age;

//    @Value("小花")
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Value("19")
//    public void setAge(int age) {
//        this.age = age;
//    }

    public User(@Value("小H") String name, @Value("20") int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
