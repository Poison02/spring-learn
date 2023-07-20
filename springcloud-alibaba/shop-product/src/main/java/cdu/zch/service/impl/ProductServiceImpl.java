package cdu.zch.service.impl;

import cdu.zch.dao.ProductDao;
import cdu.zch.entity.Product;
import cdu.zch.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Zch
 * @date 2023/7/19
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao productDao;

    @Override
    public Product findByPid(Integer pid) {
        return productDao.findById(pid).get();
    }
}
