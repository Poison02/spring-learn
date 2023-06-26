package cdu.zch.proxy.service;

/**
 * @author Zch
 * @date 2023/6/26
 **/
public interface OrderService { // 公共接口

    String getName();

    /**
     * 生成订单
     */
    void generate();

    /**
     * 修改订单信息
     */
    void modify();

    /**
     * 查看订单信息
     */
    void detail();

}
