package cdu.zch.bank.dao.impl;

import cdu.zch.bank.dao.AccountDao;
import cdu.zch.bank.pojo.Account;
import cdu.zch.bank.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author Zch
 * @data 2023/6/23
 **/
public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectByActno(String actno) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Account account = sqlSession.selectOne("account.selectByActno", actno);
        return account;
    }

    @Override
    public int updateByActno(Account act) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.update("account.updateByActno", act);
        return count;
    }
}
