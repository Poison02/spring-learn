package cdu.zch.bank.service.impl;

import cdu.zch.bank.mapper.AccountMapper;
import cdu.zch.bank.pojo.Account;
import cdu.zch.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Zch
 * @date 2023/6/28
 **/
@Transactional
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    @Qualifier("smAccountMapper")
    private AccountMapper accountMapper;

    @Override
    public int save(Account act) {
        return accountMapper.insert(act);
    }

    @Override
    public int deleteByActno(String actno) {
        return accountMapper.deleteByActno(actno);
    }

    @Override
    public int modify(Account act) {
        return accountMapper.update(act);
    }

    @Override
    public Account getByActno(String actno) {
        return accountMapper.selectByActno(actno);
    }

    @Override
    public List<Account> getAll() {
        return accountMapper.selectAll();
    }

    @Override
    public void transfer(String fromActno, String toActno, Double money) {
        Account fromAct = accountMapper.selectByActno(fromActno);
        if (fromAct.getBalance() < money) {
            throw new RuntimeException("余额不足！！！");
        }
        Account toAct = accountMapper.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        int count = accountMapper.update(fromAct);

        String s = null;
        s.toString();

        count += accountMapper.update(toAct);
        if (count != 2) {
            throw new RuntimeException("转账失败！！！");
        }
    }
}
