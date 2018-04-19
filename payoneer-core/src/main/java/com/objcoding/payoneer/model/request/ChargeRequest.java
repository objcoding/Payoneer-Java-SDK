package com.objcoding.payoneer.model.request;

import com.objcoding.payoneer.model.enums.PayoneerField;

import java.math.BigDecimal;

/**
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/19.
 */
public class ChargeRequest extends Request {

    /**
     * 付款金额
     *
     * @see PayoneerField#AMOUNT
     */
    private BigDecimal amount;

    /**
     * 订单编号
     *
     * @see PayoneerField#CLIENTREFERENCEID
     */
    private String clientReferenceId;

    /**
     * 付款描述
     *
     * @see PayoneerField#DESCRIPTION
     */
    private String description;

    /**
     * 货币种类
     *
     * @see PayoneerField#CURRENCY
     */
    private String currency;

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
