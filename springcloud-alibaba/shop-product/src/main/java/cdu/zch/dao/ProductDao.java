package cdu.zch.dao;

import cdu.zch.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zch
 * @date 2023/7/19
 **/
@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
}
