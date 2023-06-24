package cdu.zch.mapper.impl;

import cdu.zch.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

/**
 * @author Zch
 * @data 2023/6/24
 **/
@Repository
public class OrderMapperImpl implements OrderMapper {
    @Override
    public void insert() {
        System.out.println("MySQL正在保存用户数据...");
    }
}
