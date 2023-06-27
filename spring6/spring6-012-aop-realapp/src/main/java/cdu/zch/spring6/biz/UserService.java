package cdu.zch.spring6.biz;

import org.springframework.stereotype.Service;

/**
 * @author Zch
 * @date 2023/6/27
 **/
@Service("userService")
public class UserService {

    public void saveUser() {
        System.out.println("新增用户0.0");
    }

    public void deleteUser() {
        System.out.println("删除用户0.0");
    }
    public void updateUser() {
        System.out.println("修改用户0.0");
    }
    public void selectUser() {
        System.out.println("查询用户0.0");
    }
}
