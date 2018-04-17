package com.objcoding.payoneer.model.enums;

/**
 * 交易类型
 * <p>
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/13.
 */
public enum TradeType {

    /**
     * 注册授权
     */
    REGISTRATION("payees/registration-link"),
    /**
     * 授权状态
     */
    PAYEES_STATUS("payees/{payee_id}/status"),
    /**
     * 收款
     */
    CHARGE("charges"),
    /**
     * 取消收款(取消订单与退款)
     */
    CHARGE_CANCEL("charges/{client_reference_id}/cancel"),
    /**
     * 查询收款订单与订单状态
     */
    CHARGE_STATUS("charges/{client_reference_id}/status"),
    /**
     * 转账
     */
    PAYOUTS("payouts"),
    /**
     * 转账状态查询
     */
    PAYOUT_STATUS("payouts/{client_reference_id}");

    private String method;

    TradeType(String method) {
        this.method = method;
    }

    public String getType() {
        return this.name();
    }

    /**
     * 获取接口名称
     *
     * @return 接口名称
     */
    public String getMethod() {
        return this.method;
    }
}
