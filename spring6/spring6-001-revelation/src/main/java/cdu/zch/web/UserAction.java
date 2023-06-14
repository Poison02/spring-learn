package cdu.zch.web;

import cdu.zch.service.UserService;
import cdu.zch.service.impl.UserServiceImpl;

/**
 * @author Zch
 * @data 2023/6/14
 **/
public class UserAction {

    private UserService userService = new UserServiceImpl();

    /**
     * 删除用户信息的请求
     */
    public void deleteRequest() {
        userService.deleteUser();
    }

}
