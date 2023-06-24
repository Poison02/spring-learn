package cdu.zch.service.impl;

import cdu.zch.mapper.OrderMapper;
import cdu.zch.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Zch
 * @data 2023/6/24
 **/
@Service
public class OrderServiceImpl implements OrderService {

    // @Autowired 使用的时候，不需要指定任何属性，直接使用即可，默认是byType进行自动装配
//    @Autowired
//    private OrderMapper orderMapper;

    // 如果解决两个类类型一样的问题，可以使用Qualifier
    // @Autowired
    // @Qualifier("orderMapperImplForOracle")
    private OrderMapper orderMapper;

    // @Autowired
//    public OrderServiceImpl(OrderMapper orderMapper) {
//        this.orderMapper = orderMapper;
//    }

    //    @Autowired
//    public void setOrderMapper(OrderMapper orderMapper) {
//        this.orderMapper = orderMapper;
//    }


//    public OrderServiceImpl(@Autowired OrderMapper orderMapper) {
//        this.orderMapper = orderMapper;
//    }

    // 省略Autowired，但构造方法只能有一个，并且参数能对的上
    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public void generate() {
        orderMapper.insert();
    }
}
