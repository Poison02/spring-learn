package cdu.zch.bank.service.impl;

import cdu.zch.bank.dao.AccountDao;
import cdu.zch.bank.pojo.Account;
import cdu.zch.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zch
 * @date 2023/6/28
 **/
@Service("accountService")
// @Transactional // 该类上所有方法都有事务
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void transfer(String fromActno, String toActno, Double money) {

        /*
        事务：
            1. 提交事务
            2. 提交事务（无异常
            3. 回滚事务（有异常
         */

        // 查询账户余额是否充足
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance() < money) {
            throw new RuntimeException("账户余额不足");
        }
        // 余额充足，开始转账
        Account toAct = accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);

        /*String s = null;
        s.toString();*/

        toAct.setBalance(toAct.getBalance() + money);
        int count = accountDao.update(fromAct);
        count += accountDao.update(toAct);
        if (count != 2) {
            throw new RuntimeException("转账失败，请联系银行");
        }
    }

    @Resource(name = "accountService2")
    private AccountService accountService;
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Account act) {

        // 调用自己dao
        accountDao.insert(act);

        // 调用accountService2
        try {
            Account act2 = new Account("act_004", 20000D);
            accountService.save(act2);
        } catch (Exception e) {

        }

    }
}
