package cdu.zch.bank.service.impl;

import cdu.zch.bank.dao.AccountDao;
import cdu.zch.bank.pojo.Account;
import cdu.zch.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zch
 * @date 2023/6/28
 **/
@Service("accountService2")
// @Transactional // 该类上所有方法都有事务
public class AccountServiceImpl2 implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    public void transfer(String fromActno, String toActno, Double money) {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Account act) {
        accountDao.insert(act);
        // 模拟异常
        String s = null;
        s.toString();
    }
}
