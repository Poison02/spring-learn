package cdu.zch.junit.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * 单元测试类
 * 名字规范：测试类加Test
 * @author Zch
 * @data 2023/6/16
 **/
public class MathServiceTest {

    // 一般是一个业务方法对应一个测试方法
    // 测试方法的规范：testXXX()
    // 假设要测试sum，则方法名为：testSum()
    // 这个注解就代表是一个测试类
    @Test
    public void testSum() {
        /*
        单元测试中有两个重要的概念
            实际值：被测试的业务方法的真正执行结果
            期望值：期望执行方法之后的结果
         */
        MathService mathService = new MathService();
        // 实际值
        int actual = mathService.sum(1, 2);
        // 期望值
        int expected = 3;
        // 加断言进行测试
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSub() {
        MathService mathService = new MathService();
        // 实际值
        int actual = mathService.sub(1, 2);
        // 期望值
        int expected = -1;
        // 加断言进行测试
        Assert.assertEquals(expected, actual);
    }

}
