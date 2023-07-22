package cdu.zch.controller;

import cdu.zch.entity.Product;
import cdu.zch.service.ProductService;
import com.alibaba.fastjson.JSON;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
