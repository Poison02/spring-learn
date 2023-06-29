package cdu.zch.userservice.controller;

import cdu.zch.userservice.doMain.Order;
import cdu.zch.userservice.feign.UserOrderFeign;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Zch
 * @date 2023/6/29
 **/
@RestController
public class UserController {

    @Autowired
    private UserOrderFeign userOrderFeign;

    /**
     * 远程调用：默认等待时间为1s，需要修改就配置
     */
    @GetMapping("/userDoOrder")
    public String userOrder() {
        System.out.println("有用户进来了！");
        // 这里需要发起一个远程调用
        String order = userOrderFeign.order();
        System.out.println("远程调用的结果为：" + order);
        return order;
    }
    /*
    有一个需要注意的，不能够单独传递时间！！！会造成时间的误差
    可以将时间放入对象中或者转成String传递
     */

    @GetMapping("/testParam")
    public String testParam() {
        String testUrl = userOrderFeign.testUrl("张三", 20);
        System.out.println(testUrl);

        String oneParam = userOrderFeign.oneParam("zhangsan");
        System.out.println(oneParam);

        String twoParam = userOrderFeign.twoParam("zhangsan", 18);
        System.out.println(twoParam);

        Order order = Order.builder()
                .id(22)
                .name("zahngsan")
                .price(20D)
                .time(new Date())
                .build();
        String oneObj = userOrderFeign.oneObj(order);
        System.out.println(oneObj);

        String oneObjOneParam = userOrderFeign.oneObjOneParam(order, "shangsan");
        System.out.println(oneObjOneParam);

        return "OK!!!";
    }

}
