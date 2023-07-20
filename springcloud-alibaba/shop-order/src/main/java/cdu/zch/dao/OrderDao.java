package cdu.zch.dao;

import cdu.zch.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zch
 * @date 2023/7/19
 **/
@Repository
public interface OrderDao extends JpaRepository<Order, Long> {
}
