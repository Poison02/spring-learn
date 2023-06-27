package cdu.zch.spring6.service;

import org.springframework.stereotype.Service;

/**
 * @author Zch
 * @date 2023/6/27
 **/
@Service("accountService")
public class AccountService {

    public void transfer() {
        System.out.println("银行账户正在转账...00");
    }

    public void withdraw() {
        System.out.println("正在取款，请稍后...00");
    }

}
