package cdu.zch.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    public void reg(){
        System.out.println("UserController.reg()");
        userMapper.insert();
    }

}
