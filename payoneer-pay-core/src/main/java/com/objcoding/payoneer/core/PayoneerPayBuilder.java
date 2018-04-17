package com.objcoding.payoneer.core;


/**
 * Payoneer pay 构建器
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/13.
 */
public class PayoneerPayBuilder {

    private PayoneerPay payoneerPay;

    private PayoneerPayBuilder() {
    }

    public static PayoneerPayBuilder newBuilder(String programId, String authUsername, String authPassword) {
        PayoneerPayBuilder builder = new PayoneerPayBuilder();
        builder.payoneerPay = new PayoneerPay(programId, authUsername, authPassword);
        return builder;
    }

    public static PayoneerPayBuilder newBuilder(String programId, String authUsername, String authPassword,
                                                String inputCharset, boolean isTest) {
        PayoneerPayBuilder builder = new PayoneerPayBuilder();
        builder.payoneerPay = new PayoneerPay(programId, authUsername, authPassword, inputCharset, isTest);
        return builder;
    }

    public PayoneerPay build() {
        return payoneerPay.init();
    }
}
