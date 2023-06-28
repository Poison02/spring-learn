package cdu.zch.bank.dao;

import cdu.zch.bank.pojo.Account;

/**
 * 专门负责账户信息的CRUD
 * 不负责任何业务逻辑
 * @author Zch
 * @date 2023/6/28
 **/
public interface AccountDao {

    Account selectByActno(String actno);

    int update(Account act);

    int insert(Account act);

}
