package cdu.zch.reflect;

/**
 * @author Zch
 * @data 2023/6/19
 **/
public class Test {

    public static void main(String[] args) {
        // 不适用反射机制调用这些方法
        SomeService service = new SomeService();
        service.doSome();
        /**
         * 分析：嗲用一个方法，当中含有几个要素？四要素
         * 第一：调用那个对象
         * 第二：嗲用哪个方法
         * 第三：传什么参数
         * 第四：返回什么结果
         *
         * 即使使用反射机制调用方法，同样需要具备这四个要素
         */
        String s1 = service.doSome("aaa");
        System.out.println(s1);
        String s2 = service.doSome("bbb", 2);
        System.out.println(s2);
    }

}
