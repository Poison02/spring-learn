package cdu.zch.bank.pojo;

/**
 * @author Zch
 * @data 2023/6/23
 **/
public class Account {

    private Long id;
    private String actno;
    private Double balance;

    public Account() {
    }

    public Account(Long id, String actno, Double balance) {
        this.id = id;
        this.actno = actno;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getActno() {
        return actno;
    }

    public Double getBalance() {
        return balance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", actno='" + actno + '\'' +
                ", balance=" + balance +
                '}';
    }
}
