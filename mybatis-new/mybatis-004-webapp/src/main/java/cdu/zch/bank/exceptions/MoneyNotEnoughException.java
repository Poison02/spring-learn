package cdu.zch.bank.exceptions;

/**
 * @author Zch
 * @data 2023/6/23
 **/
public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException() {}
    public MoneyNotEnoughException(String msg) {
        super(msg);
    }
}
