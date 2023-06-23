package cdu.zch.bank.service;

import cdu.zch.bank.exceptions.MoneyNotEnoughException;
import cdu.zch.bank.exceptions.TransferException;

/**
 * 账户业务类
 * @author Zch
 * @data 2023/6/23
 **/
public interface AccountService {

    /**
     * 账户转账业务
     * @param fromActno 转出账号
     * @param toActno 转入账号
     * @param money 转账金额
     */
    void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, TransferException;

}
