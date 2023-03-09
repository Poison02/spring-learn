package cdu.zch.spring;

import org.springframework.stereotype.Repository;

@Repository
public class UserMapper {

    public void insert(){
        System.out.println("UserMapper ----> UserMapper.insert()");
    }
}
