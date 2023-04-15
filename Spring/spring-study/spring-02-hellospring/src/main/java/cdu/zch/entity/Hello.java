package cdu.zch.entity;

/**
 * @author Zch
 **/
public class Hello {
    private String name;

//    public Hello() {
//    }

    public Hello(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println(name);
    }
}
