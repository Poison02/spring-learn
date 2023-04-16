package cdu.zch.demo02;

/**
 * @author Zch
 *
 * 增加代理类，因为想在原有功能基础上增加日志功能
 **/
public class Proxy implements UserService{

    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }

    public void log(String msg) {
        System.out.println("[DEBUG] 调用了" + msg + "功能");
    }
}
