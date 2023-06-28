package cdu.zch.bank.service;

import cdu.zch.bank.pojo.Account;

/**
 * @author Zch
 * @date 2023/6/28
 **/
public interface AccountService {

    void transfer(String fromActno, String toActno, Double money);

}
