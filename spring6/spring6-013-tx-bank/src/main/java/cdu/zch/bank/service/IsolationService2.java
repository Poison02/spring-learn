package cdu.zch.bank.service;

import cdu.zch.bank.dao.AccountDao;
import cdu.zch.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @author Zch
 * @date 2023/6/28
 **/
@Service("i2")
public class IsolationService2 {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    // 负责insert
    // @Transactional(timeout = 10) // 设置事务超时时间为10s
    // @Transactional(rollbackFor = RuntimeException.class) // 只要发生RuntimeException才会回滚
    @Transactional(noRollbackFor = NullPointerException.class) // 发生空指针异常不回滚
    public void save(Account act) throws IOException {
        // 在这里的时间会记录超时时间
//        try {
//            Thread.sleep(1000 * 11);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        accountDao.insert(act);

        if(1 == 1) {
            // throw new IOException();
            throw new NullPointerException();
        }

        // 在DML语句后面的时间不会记录超时时间
        // 睡眠一会儿，先等待查询语句执行
//        try {
//            Thread.sleep(1000 * 20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

}
