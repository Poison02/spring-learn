package cdu.zch.bean;

import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author Zch
 * @data 2023/6/16
 **/
public class SimpleValueType {

    /*
    return Void.class != type && Void.TYPE != type &&
            (ClassUtils.isPrimitiveOrWrapper(type) ||
            Enum.class.isAssignableFrom(type) ||
            CharSequence.class.isAssignableFrom(type) ||
            Number.class.isAssignableFrom(type) ||
            Date.class.isAssignableFrom(type) ||  // java.util.Date
            Temporal.class.isAssignableFrom(type) ||  // java 8以后提供的时区类型
            URI.class == type ||
            URL.class == type ||
            Locale.class == type ||  // 语言类
            Class.class == type);
     */
    // 测试简单类型
    private int age;
    private Integer age2;
    private boolean flag;
    private Boolean flag2;
    private char c;
    private Character c2;

    private Season season;
    private String username;
    private Class clazz;

    private Date birth;

    @Override
    public String toString() {
        return "SimpleValueType{" +
                "age=" + age +
                ", age2=" + age2 +
                ", flag=" + flag +
                ", flag2=" + flag2 +
                ", c=" + c +
                ", c2=" + c2 +
                ", season=" + season +
                ", username='" + username + '\'' +
                ", clazz=" + clazz +
                ", birth=" + birth +
                '}';
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAge2(Integer age2) {
        this.age2 = age2;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setFlag2(Boolean flag2) {
        this.flag2 = flag2;
    }

    public void setC(char c) {
        this.c = c;
    }

    public void setC2(Character c2) {
        this.c2 = c2;
    }
}
