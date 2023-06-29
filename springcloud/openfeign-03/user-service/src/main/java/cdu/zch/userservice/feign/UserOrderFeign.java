package cdu.zch.userservice.feign;

import cdu.zch.userservice.doMain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Zch
 * @date 2023/6/29
 **/
// value 就是提供者的应用名称
@FeignClient(value = "order-service")
public interface UserOrderFeign {

    /**
     * 需要调用哪个controller，就写方法签名（包含一个方法的所有属性）
     * @return
     */
    @GetMapping("/doOrder")
    public String order();

    @GetMapping("/testUrl/{name}/and/{age}")
    public String testUrl(@PathVariable("name") String name, @PathVariable("age") Integer age);

    @GetMapping("/oneParam")
    public String oneParam(@RequestParam(required = false) String name);

    @GetMapping("/twoParam")
    public String twoParam(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age);

    @PostMapping("/oneObj")
    public String oneObj(@RequestBody Order order);

    @PostMapping("/oneObjOneParam")
    public String oneObjOneParam(@RequestBody Order order, @RequestParam(required = false) String name);

}
