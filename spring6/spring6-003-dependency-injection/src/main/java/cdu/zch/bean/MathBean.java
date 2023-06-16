package cdu.zch.bean;

/**
 * @author Zch
 * @data 2023/6/16
 **/
public class MathBean {

    // 注入特殊符号
    private String result;

    @Override
    public String toString() {
        return "MathBean{" +
                "result='" + result + '\'' +
                '}';
    }

    public void setResult(String result) {
        this.result = result;
    }
}
