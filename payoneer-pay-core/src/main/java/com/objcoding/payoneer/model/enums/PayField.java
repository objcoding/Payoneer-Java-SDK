package com.objcoding.payoneer.model.enums;

/**
 * payoneer pay 相关字段集
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/17.
 */
public enum PayField {

    PROGRAMID("grogram_id", "商户id"),

    AUTH_USERNAME("username", "用于basic auth 验证的用户名"),

    AUTH_PASSDWORD("password", "用于basic auth 验证的密码"),

    PAYEEID("payee_id", "授权到商户系统里用于标识用户的id，类似于openid"),

    AMOUNT("amount", "付款金额"),

    CLIENTREFERENCEID("client_Reference_Id", "订单编号"),

    DESCRIPTION("description", "付款描述"),

    CURRENCY("currency", "货币种类");

    private String field;

    private String desc;

    PayField(String field, String desc) {
        this.field = field;
        this.desc = desc;
    }

    public String field() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String desc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
