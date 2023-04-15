package cdu.zch.mapper;

import cdu.zch.entity.User;

import java.util.List;

/**
 * @author Zch
 **/
public interface UserMapper {
    List<User> getUserList();
    User getUserById(int id);
    Integer addUser(User user);
    Integer modUser(User user);
    Integer delUser(int id);
}
