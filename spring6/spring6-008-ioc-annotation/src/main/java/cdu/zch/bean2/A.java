package cdu.zch.bean2;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author Zch
 * @data 2023/6/24
 **/
@Component
public class A {
    public A() {
        System.out.println("A无参构造");
    }
}
@Controller
class B {
    public B() {
        System.out.println("B无参构造");
    }
}
@Service
class C {
    public C() {
        System.out.println("C无参构造");
    }
}
@Repository
class D {
    public D() {
        System.out.println("D无参构造");
    }
}
@Component
class E {
    public E() {
        System.out.println("E无参构造");
    }
}