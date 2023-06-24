package cdu.zch.bank.service.impl;

import cdu.zch.bank.dao.AccountDao;
import cdu.zch.bank.dao.impl.AccountDaoImpl;
import cdu.zch.bank.exceptions.MoneyNotEnoughException;
import cdu.zch.bank.exceptions.TransferException;
import cdu.zch.bank.pojo.Account;
import cdu.zch.bank.service.AccountService;
import cdu.zch.bank.util.GenerateDaoProxy;
import cdu.zch.bank.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author Zch
 * @data 2023/6/23
 **/
public class AccountServiceImpl implements AccountService {

    // private AccountDao accountDao = new AccountDaoImpl();

    // 自己封装
    // private AccountDao accountDao = (AccountDao) GenerateDaoProxy.generate(SqlSessionUtil.openSession(), AccountDao.class);

    // mybatis提供了dao接口的代理机制
    // mybatis实际上采用了代理模式，在内存中生成dao接口的代理类，然后创建代理类的示例
    // 使用这种代理机制的前提，sqlMapper.xml中的namespace和id必须按照规定写！
    private AccountDao accountDao = SqlSessionUtil.openSession().getMapper(AccountDao.class);

    @Override
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, TransferException {

        // 添加事务控制代码
        SqlSession sqlSession = SqlSessionUtil.openSession();

        // 1. 判断转出账户的余额是否充足 select
        Account fromAct = accountDao.selectByActno(fromActno);
        Account toAct = accountDao.selectByActno(toActno);
        if (fromAct.getBalance() < money) {
            // 2. 如果余额不足，提醒用户
            throw new MoneyNotEnoughException("对不起，余额不足！");
        }
        // 3. 余额充足，更新转出账户 update
        // 先更新内存中Java对象的account的余额
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        int count = accountDao.updateByActno(fromAct);

        // 4. 更新转入账户余额 update
        count += accountDao.updateByActno(toAct);
        if (count != 2) {
            throw new TransferException("转账失败！");
        }

        // 提交事务
        sqlSession.commit();
        // 关闭事务
        SqlSessionUtil.close(sqlSession);
    }
}
