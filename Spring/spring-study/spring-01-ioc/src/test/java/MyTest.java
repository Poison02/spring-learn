import cdu.zch.dao.UserDaoImpl;
import cdu.zch.dao.UserDaoMysqlImpl;
import cdu.zch.service.UserService;
import cdu.zch.service.UserServiceImpl;
import org.junit.Test;

/**
 * @author Zch
 **/
public class MyTest {
    @Test
    public void test() {

//        UserService userService = new UserServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();

        userService.setUserDao(new UserDaoImpl());
        userService.getUser();
        userService.setUserDao(new UserDaoMysqlImpl());
        userService.getUser();
    }
}
