package cdu.zch.mybatis.mapper;

import cdu.zch.mybatis.pojo.Car;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * @author Zch
 * @data 2023/6/24
 **/
public interface CarMapper {

    int insert(Car car);

    int deleteById(Long id);

    int update(Car car);

    Car selectById(Long id);

    List<Car> selectAll();

    Map<String, Object> selectByIdRetMap(Long id);

    List<Map<String, Object>> selectRetMap();

    // key 是数据库中每条记录的主键值
    // value 是每条记录
    @MapKey("id") // 将查询结果的id值作为整个Map集合的key
    Map<Long, Map<String, Object>> selectAllRetMap();

    // 使用ResultMap标签进行结果的映射
    List<Car> selectAllByResultMap();

    // 使用驼峰命名自动映射
    List<Car> selectAllByMapUnderscoreToCamelCase();

}
