package cdu.zch.mybatis.pojo;

import java.util.List;

/**
 * @author Zch
 * @date 2023/6/28
 **/
public class Clazz {

    private Integer cid;
    private String cname;

    private List<Student> stus;

    public Clazz() {
    }



    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Student> getStus() {
        return stus;
    }

    public void setStus(List<Student> stus) {
        this.stus = stus;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", stus=" + stus +
                '}';
    }
}
