package cdu.zch.reflect;

/**
 * @author Zch
 * @data 2023/6/19
 **/
public class SomeService {

    public void doSome() {
        System.out.println("void doSome()...");
    }

    public String doSome(String s) {
        System.out.println("String doSome(String s)...");
        return s;
    }

    public String doSome(String s, int i) {
        System.out.println("String doSome(String s, int i)...");
        return s + i;
    }

}
