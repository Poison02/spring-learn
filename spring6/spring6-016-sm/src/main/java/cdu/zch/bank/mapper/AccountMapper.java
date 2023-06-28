package cdu.zch.bank.mapper;

import cdu.zch.bank.pojo.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zch
 * @date 2023/6/28
 **/
@Repository("smAccountMapper")
public interface AccountMapper {

    int insert(Account account);
    int deleteByActno(String actno);
    int update(Account account);
    Account selectByActno(String actno);
    List<Account> selectAll();

}
