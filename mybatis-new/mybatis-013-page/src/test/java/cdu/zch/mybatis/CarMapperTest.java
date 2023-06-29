package cdu.zch.mybatis;

import cdu.zch.mybatis.mapper.CarMapper;
import cdu.zch.mybatis.pojo.Car;
import cdu.zch.mybatis.pojo.CarExample;
import cdu.zch.mybatis.utils.SqlSessionUtil;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.github.pagehelper.PageHelper;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Zch
 * @date 2023/6/27
 **/
public class CarMapperTest {

    @Test
    public void testSelectByPage() {
        // 每页记录条数
        int pageSize  = 3;
        // 第几页
        int pageNum = 2;
        // 起始下标
        int startIndex = (pageNum - 1) * pageSize;
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByPage(startIndex, pageSize);
        cars.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        // 一定要注意，执行DQL之前开启分页功能
        int pageNum = 2;
        int pageSize = 3;
        PageHelper.startPage(pageNum, pageSize);
        List<Car> cars = mapper.selectAll();
        // cars.forEach(System.out::println);
        // 封装PageInfo对象，用来封装分页相关的信息的对象
        PageInfo<Car> carPageInfo = new PageInfo<>(cars, 3);
        System.out.println(carPageInfo);

        /*
        PageInfo{pageNum=2, pageSize=3, size=3, startRow=4, endRow=6, total=6, pages=2,
        list=Page{count=true, pageNum=2, pageSize=3,startRow=3, endRow=6, total=6, pages=2, reasonable=false, pageSizeZero=false}
        [Car{id=20, carNum='2001', brand='兰博基尼', guidePrice=100.00, produceTime='1998-10-11', carType='燃油车'},
        Car{id=21, carNum='2001', brand='兰博基尼', guidePrice=100.00, produceTime='1998-10-11', carType='燃油车'},
        Car{id=22, carNum='2001', brand='兰博基尼', guidePrice=100.00, produceTime='1998-10-11', carType='燃油车'}],
        prePage=1, nextPage=0, isFirstPage=false, isLastPage=true, hasPreviousPage=true, hasNextPage=false,
        navigatePages=3, navigateFirstPage=1, navigateLastPage=2, navigatepageNums=[1, 2]}
         */

        sqlSession.close();
    }

}
