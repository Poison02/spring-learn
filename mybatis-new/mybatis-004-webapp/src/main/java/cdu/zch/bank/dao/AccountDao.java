package cdu.zch.bank.dao;

import cdu.zch.bank.pojo.Account;

/**
 * 账户的DAO对象，负责t_act表中数据的CRUD
 * DAO对象中的任何一个方法和业务不挂钩，没有任何业务逻辑
 * @author Zch
 * @data 2023/6/23
 **/
public interface AccountDao {

    /**
     * 根据账号查询账户信息
     * @param actno 账户
     * @return 账户信息
     */
    Account selectByActno(String actno);

    /**
     * 更新账户信息
     * @param act 账户
     * @return 1成功 0失败
     */
    int updateByActno(Account act);

}
