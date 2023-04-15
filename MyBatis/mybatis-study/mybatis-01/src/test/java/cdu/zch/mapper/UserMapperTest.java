package cdu.zch.mapper;

import cdu.zch.entity.User;
import cdu.zch.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author Zch
 **/
public class UserMapperTest {

    @Test
    public void getUserList() {
        SqlSession session = MybatisUtils.getSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        session.close();
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUserById(1);

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Integer row = userMapper.addUser(new User(3,"wanger", "321"));

        System.out.println(row);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void modUser() {
        SqlSession sqlSession = MybatisUtils.getSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Integer row = userMapper.modUser(new User(3, "hahah", "123321"));

        System.out.println(row);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void delUser() {
        SqlSession sqlSession = MybatisUtils.getSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Integer row = userMapper.delUser(3);

        System.out.println(row);

        sqlSession.commit();

        sqlSession.close();
    }
}
