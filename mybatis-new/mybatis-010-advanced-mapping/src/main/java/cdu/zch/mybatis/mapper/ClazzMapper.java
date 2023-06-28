package cdu.zch.mybatis.mapper;

import cdu.zch.mybatis.pojo.Clazz;

/**
 * @author Zch
 * @date 2023/6/28
 **/
public interface ClazzMapper {

    /**
     * 分部查询第二步，根据cid获取班级信息
     * @param cid
     * @return
     */
    Clazz selectById(Integer cid);

    /**
     * 根据班级id查询班级信息
     * @param cid
     * @return
     */
    Clazz selectByCollection(Integer cid);

    /**
     * 一对多，分步查询第一步
     * @param cid
     * @return
     */
    Clazz selectByStep1(Integer cid);

}
