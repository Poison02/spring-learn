package cdu.zch.spring6.bean;

import java.util.Date;

/**
 * @author Zch
 * @data 2023/6/18
 **/
public class Student {

    /*
    Date在Spring中当作简单类型，但是对格式有要求，也可以当作非简单类型
     */
    private Date birth;

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "birth=" + birth +
                '}';
    }
}
