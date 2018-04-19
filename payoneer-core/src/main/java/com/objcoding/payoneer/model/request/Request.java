package com.objcoding.payoneer.model.request;

import com.objcoding.payoneer.model.enums.PayoneerField;

import java.io.Serializable;

/**
 * payoneer 支付请求对象
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/13.
 */
public class Request implements Serializable {

    /**
     * 授权到商户系统里用于标识用户的id，类似于openid
     *
     * @see PayoneerField#PAYEEID
     */
    private String payeeId;

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }
}
