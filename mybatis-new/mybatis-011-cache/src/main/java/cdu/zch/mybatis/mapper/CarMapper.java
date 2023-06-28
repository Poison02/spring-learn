package cdu.zch.mybatis.mapper;

import cdu.zch.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Zch
 * @data 2023/6/24
 **/
public interface CarMapper {

    /**
     * 根据id获取car
     * @param id
     * @return
     */
    Car selectById(Long id);

    /**
     * 测试二级缓存
     * @param id
     * @return
     */
    Car selectById2(Long id);

}
