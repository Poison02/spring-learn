package cdu.zch.mapper;

import cdu.zch.entity.Department;
import cdu.zch.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zch
 **/
@Repository
public class EmployeeMapper {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentMapper departmentMapper;

    static  {
        //创建一个部门表
        employees = new HashMap<Integer, Employee>();
        employees.put(1001,new Employee(101, "A", "a123465@qq.com", 1, new Department(101, "教学部"), new Date()));
        employees.put(1002,new Employee(102, "B", "b123465@qq.com", 0, new Department(102, "市场部"), new Date()));
        employees.put(1003,new Employee(103, "C", "c123465@qq.com", 0, new Department(103, "教研部"), new Date()));
        employees.put(1004,new Employee(104, "D", "d123465@qq.com", 1, new Department(104, "运营部"), new Date()));
        employees.put(1005,new Employee(105, "E", "e123465@qq.com", 0, new Department(105, "后勤部"), new Date()));
    }

    private static Integer initId = 1006;

    public int add(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentMapper.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);

        return 1;
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    public int delete(Integer id) {
        return employees.remove(id) == null ? 0 : 1;
    }
}
