package com.objcoding.payoneer.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * payoneer 支付请求对象
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/13.
 */
public class PayRequest implements Serializable {

    /**
     * 授权到商户系统里用于标识用户的id，类似于openid
     */
    private String payeeId;

    /**
     * 付款金额
     */
    private BigDecimal amount;

    /**
     * 订单编号
     */
    private String clientReferenceId;

    /**
     * 付款描述
     */
    private String description;

    /**
     * 货币种类
     */
    private String currency;


    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getClientReferenceId() {
        return clientReferenceId;
    }

    public void setClientReferenceId(String clientReferenceId) {
        this.clientReferenceId = clientReferenceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
