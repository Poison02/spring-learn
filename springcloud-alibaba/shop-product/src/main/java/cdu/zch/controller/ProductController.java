package cdu.zch.controller;

import cdu.zch.entity.Product;
import cdu.zch.service.ProductService;
import com.alibaba.fastjson.JSON;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author Zch
 * @date 2023/7/19
 **/
@RestController
@Slf4j
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/product/{pid}")
    // , @RequestParam("age") String age
    public Product product(@PathVariable("pid") Integer pid) {
        Product product = productService.findByPid(pid);
        log.info("查询到商品是: " + JSON.toJSONString(product));
        // log.info("age: " + age);
        return product;
    }

    @RequestMapping("/product/reduceInventory")
    public void reduceInventory(@RequestParam("pid") Integer pid, @RequestParam("num") int num) {
        productService.reduceInventory(pid, num);
    }

}
