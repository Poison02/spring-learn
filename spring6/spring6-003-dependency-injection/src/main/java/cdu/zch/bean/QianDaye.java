package cdu.zch.bean;

import java.util.Arrays;

/**
 * @author Zch
 * @data 2023/6/16
 **/
public class QianDaye {

    // 演示数组注入
    private String[] aiHaos;

    @Override
    public String toString() {
        return "QianDaye{" +
                "aiHaos=" + Arrays.toString(aiHaos) +
                ", women=" + Arrays.toString(women) +
                '}';
    }

    public void setWomen(Women[] women) {
        this.women = women;
    }

    // 多个朋友
    private Women[] women;

    public void setAiHaos(String[] aiHaos) {
        this.aiHaos = aiHaos;
    }
}
