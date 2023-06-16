package cdu.zch.bean;

/**
 * @author Zch
 * @data 2023/6/16
 **/
public class Student {

    // 学生名称
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", clazz=" + clazz +
                '}';
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

//    使用级联属性赋值，需要有对应的get方法


    public Clazz getClazz() {
        return clazz;
    }

    // 学生属于那个班级
    private Clazz clazz;

    public void setName(String name) {
        this.name = name;
    }

}
