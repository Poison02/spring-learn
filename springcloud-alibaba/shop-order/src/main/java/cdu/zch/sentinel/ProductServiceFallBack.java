package cdu.zch.sentinel;

import cdu.zch.entity.Product;
import cdu.zch.feign.ProductService;
import org.springframework.stereotype.Component;

/**
 * @author Zch
 * @date 2023/7/20
 **/
@Component
public class ProductServiceFallBack implements ProductService {
    @Override
    public Product product(Integer pid) {
        Product product = new Product();

        product.setPid(-1);

        return product;
    }

    @Override
    public void reduceInventory(Integer pid, int num) {

    }
}
