package cdu.zch.mapper;

import cdu.zch.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zch
 * 模拟部门假数据
 **/
@Repository
public class DepartmentMapper {

    private static Map<Integer, Department> departments = null;

    static  {
        //创建一个部门表
        departments = new HashMap<Integer, Department>();
        departments.put(101,new Department(101, "教学部"));
        departments.put(102,new Department(102, "市场部"));
        departments.put(103,new Department(103, "教研部"));
        departments.put(104,new Department(104, "运营部"));
        departments.put(105,new Department(105, "后勤部"));
    }

    /**
     * 得到所有员工集合
     * */
    public Collection<Department> getDepartment() {
        return departments.values();
    }

    /**
     * @param id 员工id
     * @return 得到指定员工
     */
    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }
}
