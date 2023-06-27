package cdu.zch.spring6.service;

import org.springframework.stereotype.Service;

/**
 * @author Zch
 * @date 2023/6/27
 **/
@Service("userService")
public class UserService { // 目标类

    public void login() { // 目标方法
        System.out.println("正在进行登录认证");
    }

    public void logout() {
        System.out.println("退出程序中..");
    }

}
