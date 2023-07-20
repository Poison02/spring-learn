package cdu.zch.service;

import cdu.zch.entity.Product;

/**
 * @author Zch
 * @date 2023/7/19
 **/
public interface ProductService {

    Product findByPid(Integer pid);

}
