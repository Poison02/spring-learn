package cdu.zch.mybatis.mapper;

import cdu.zch.mybatis.pojo.Car;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Zch
 * @data 2023/6/24
 **/
public interface CarMapper {

    /**
     * 多条件查询
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByMultiCondition(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

    /**
     * 使用where标签，使where语句更智能
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByMultiConditionWithWhere(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

    /**
     * 使用trim标签
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByMultiConditionWithTrim(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

    /**
     * 使用set标签
     * @param car
     * @return
     */
    int updateById(Car car);

    /**
     * 使用choose when otherwise标签查询
     * @param brand
     * @param guidePrice
     * @param produceTime
     * @return
     */
    List<Car> selectWithChoose(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("produceTime") String produceTime);

    /**
     * 通过foreach完成批量删除，in删除
     * @param ids
     * @return
     */
    int deleteBatchByForeach(@Param("ids") Long[] ids);

    /**
     * 通过foreach完成批量删除，or删除
     * @param ids
     * @return
     */
    int deleteBatchByForeach2(@Param("ids") Long[] ids);

    /**
     * 批量添加，使用foreach标签
     * @param cars
     * @return
     */
    int insertBatchByForeach(@Param("cars") List<Car> cars);

    List<Map<String, Object>> selectAllRetListMap();

    Map<String, Object> selectByIdRetMap(Long id);

}
