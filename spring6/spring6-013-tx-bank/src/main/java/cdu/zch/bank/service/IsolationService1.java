package cdu.zch.bank.service;

import cdu.zch.bank.dao.AccountDao;
import cdu.zch.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zch
 * @date 2023/6/28
 **/
@Service("i1")
public class IsolationService1 {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    // 负责select
    // 这个隔离级别标识可以读到别人未提交的信息，脏读
    // @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    // 读提交，只能读到提交之后的数据
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void getByActno(String actno) {
        Account account = accountDao.selectByActno(actno);
        System.out.println("查询到的信息：" + account);
    }

}
