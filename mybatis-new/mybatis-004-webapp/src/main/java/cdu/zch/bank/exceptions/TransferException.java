package cdu.zch.bank.exceptions;

/**
 * 转账异常
 * @author Zch
 * @data 2023/6/23
 **/
public class TransferException extends Exception{

    public TransferException() {}
    public TransferException(String msg) {
        super(msg);
    }

}
