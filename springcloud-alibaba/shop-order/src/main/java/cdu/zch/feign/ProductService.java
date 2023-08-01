package cdu.zch.feign;

import cdu.zch.entity.Product;
import cdu.zch.sentinel.ProductServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Zch
 * @date 2023/7/19
 **/
// fallback 用于指定容错类
@FeignClient(value = "service-product", fallback = ProductServiceFallBack.class)
public interface ProductService {

    // 指定调用提供者的哪个方法，这里需要把提供者的方法完整名字拿过来
    @GetMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid);

    // 扣库存
    @RequestMapping("/product/reduceInventory")
    void reduceInventory(@RequestParam("pid") Integer pid, @RequestParam("num") int num);

}
