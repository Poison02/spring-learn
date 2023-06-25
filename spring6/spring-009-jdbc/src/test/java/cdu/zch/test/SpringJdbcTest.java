package cdu.zch.test;

import cdu.zch.spring6.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Zch
 * @date 2023/6/25
 **/
public class SpringJdbcTest {

    @Test
    public void testJdbc() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
    }

    @Test
    public void testInsert() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into t_user values(null, ?, ?);";
        // 在JdbcTemplate中只要是insert delete update，都是调用update方法
        int row = jdbcTemplate.update(sql, "王五", 20);
        System.out.println(row);
    }

    @Test
    public void testUpdate() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "update t_user set real_name=?, age=? where id=?;";
        // 在JdbcTemplate中只要是insert delete update，都是调用update方法
        int row = jdbcTemplate.update(sql, "张三丰", 50, 1);
        System.out.println(row);
    }

    @Test
    public void testDelete() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "delete from t_user where id=?;";
        // 在JdbcTemplate中只要是insert delete update，都是调用update方法
        int row = jdbcTemplate.update(sql, 3);
        System.out.println(row);
    }

    // 查询一个对象
    @Test
    public void testQueryOne() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from t_user where id=?;";
        User user =  jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 2);
        System.out.println(user);
    }

    // 查询全部对象
    @Test
    public void testQueryAll() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from t_user";
        List<User> users =  jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        users.forEach(System.out::println);
    }

    // 查询一个值
    @Test
    public void testQueryOneValue() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select count(*) from t_user";
        Integer count =  jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

    // 批量添加
    @Test
    public void testAddBatch(){
        // 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 批量添加
        String sql = "insert into t_user(id,real_name,age) values(?,?,?)";

        Object[] objs1 = {null, "小花", 20};
        Object[] objs2 = {null, "小明", 21};
        Object[] objs3 = {null, "小刚", 22};
        List<Object[]> list = new ArrayList<>();
        list.add(objs1);
        list.add(objs2);
        list.add(objs3);

        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }

    // 批量修改
    @Test
    public void testUpdateBatch(){
        // 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 批量修改
        String sql = "update t_user set real_name = ?, age = ? where id = ?";
        Object[] objs1 = {"小花11", 10, 2};
        Object[] objs2 = {"小明22", 12, 3};
        Object[] objs3 = {"小刚33", 9, 4};
        List<Object[]> list = new ArrayList<>();
        list.add(objs1);
        list.add(objs2);
        list.add(objs3);

        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }

    // 批量删除
    @Test
    public void testDeleteBatch(){
        // 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 批量删除
        String sql = "delete from t_user where id = ?";
        Object[] objs1 = {2};
        Object[] objs2 = {5};
        Object[] objs3 = {4};
        List<Object[]> list = new ArrayList<>();
        list.add(objs1);
        list.add(objs2);
        list.add(objs3);
        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }

    // 如果想写jdbc代码，可以使用callback回调函数
    @Test
    public void testCallback(){
        // 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select id, real_name, age from t_user where id = ?";

        User user = jdbcTemplate.execute(sql, new PreparedStatementCallback<User>() {
            @Override
            public User doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                User user = null;
                ps.setInt(1, 6);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setRealName(rs.getString("real_name"));
                    user.setAge(rs.getInt("age"));
                }
                return user;
            }
        });
        System.out.println(user);
    }

}
