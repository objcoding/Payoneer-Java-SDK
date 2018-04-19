package com.objcoding.payoneer.core;


/**
 * Payoneer pay 构建器
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/13.
 */
public class PayoneerBuilder {

    private Payoneer payoneer;

    private PayoneerBuilder() {
    }

    public static PayoneerBuilder newBuilder(String programId, String authUsername, String authPassword) {
        PayoneerBuilder builder = new PayoneerBuilder();
        builder.payoneer = new Payoneer(programId, authUsername, authPassword);
        return builder;
    }

    public static PayoneerBuilder newBuilder(String programId, String authUsername, String authPassword,
                                             String inputCharset, boolean isTest) {
        PayoneerBuilder builder = new PayoneerBuilder();
        builder.payoneer = new Payoneer(programId, authUsername, authPassword, inputCharset, isTest);
        return builder;
    }

    public Payoneer build() {
        return payoneer.init();
    }
}
