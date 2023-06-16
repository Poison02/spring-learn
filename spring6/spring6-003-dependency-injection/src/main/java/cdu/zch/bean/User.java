package cdu.zch.bean;

/**
 * @author Zch
 * @data 2023/6/16
 **/
public class User {

    // 演示注入简单类型

    private String username;

    private String password;

    private int age;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
