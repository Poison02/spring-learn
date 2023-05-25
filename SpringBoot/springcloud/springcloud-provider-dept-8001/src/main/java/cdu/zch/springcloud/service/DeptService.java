package cdu.zch.springcloud.service;

import cdu.zch.springcloud.api.entity.Dept;

import java.util.List;

/**
 * @author Zch
 * @data 2023/5/25
 **/
public interface DeptService {

    public boolean addDept(Dept dept);

    public Dept queryById(Long id);

    public List<Dept> queryAll();

}
