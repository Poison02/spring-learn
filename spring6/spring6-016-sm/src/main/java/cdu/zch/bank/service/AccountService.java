package cdu.zch.bank.service;

import cdu.zch.bank.pojo.Account;

import java.util.List;

/**
 * @author Zch
 * @date 2023/6/28
 **/
public interface AccountService {

    int save(Account act);

    int deleteByActno(String actno);

    int modify(Account act);

    Account getByActno(String actno);

    List<Account> getAll();

    void transfer(String fromActno, String toActno, Double money);

}
