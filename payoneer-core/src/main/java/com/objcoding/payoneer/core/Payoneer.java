package com.objcoding.payoneer.core;

import com.objcoding.payoneer.model.enums.CharsetType;

/**
 * payoneer pay 核心类
 * <p>
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/13.
 */
public class Payoneer {

    /**
     * 测试地址
     */
    public static final String SANDBOX_DOMAIN = "https://api.sandbox.payoneer.com/v2/programs/";

    /**
     * 正式地址
     */
    public final static String RELEASE_DOMAIN = "https://api.payoneer.com/v2/programs/";


    private String programId;

    /**
     * 商户网站使用的编码格式，如utf-8、gbk、gb2312等
     */
    private String inputCharset = CharsetType.UTF8.name();

    /**
     * 是否是测试环境
     */
    private boolean isTest = true;

    /**
     * basic auth username
     */
    private String authUsername;

    /**
     * basic auht password
     */
    private String authPassword;

    /**
     * 付款组件
     */
    private Charges charges;

    /**
     * 用户状态组件
     */
    private Payees payees;

    /**
     * 通知组件
     */
    private Notifies notifies;

    /**
     * 转账组件（支出）
     */
    private Payouts payouts;

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getInputCharset() {
        return inputCharset;
    }

    public void setInputCharset(String inputCharset) {
        this.inputCharset = inputCharset;
    }

    public boolean isTest() {
        return isTest;
    }

    public void setTest(boolean test) {
        isTest = test;
    }

    public String getAuthUsername() {
        return authUsername;
    }

    public void setAuthUsername(String authUsername) {
        this.authUsername = authUsername;
    }

    public String getAuthPassword() {
        return authPassword;
    }

    public void setAuthPassword(String authPassword) {
        this.authPassword = authPassword;
    }

    public Payoneer(String programId, String authUsername, String authPassword) {
        this.programId = programId;
        this.authUsername = authUsername;
        this.authPassword = authPassword;
    }

    public Payoneer(String programId, String authUsername, String authPassword, String inputCharset, boolean isTest) {
        this.programId = programId;
        this.inputCharset = inputCharset;
        this.isTest = isTest;
        this.authUsername = authUsername;
        this.authPassword = authPassword;
    }

    public Payoneer init() {
        charges = new Charges(this);
        payees = new Payees(this);
        notifies = new Notifies(this);
        return this;
    }

    public Notifies notifies() {
        return notifies;
    }


    public Charges charges() {
        return charges;
    }

    public Payees payees() {
        return payees;
    }

    public Payouts payouts() {
        return payouts;
    }
}
