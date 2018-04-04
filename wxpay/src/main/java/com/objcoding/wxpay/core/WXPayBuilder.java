package com.objcoding.wxpay.core;

import com.objcoding.wxpay.config.H5WXPayAccount;
import com.objcoding.wxpay.config.WechatPayConfig;

/**
 * 微信支付组件构建器
 * <p>
 * Created by chenghui.zhang on 2018/4/2.
 */
public class WXPayBuilder {

    private WXPay wxPay;

    public static WXPayBuilder newBuilderH5() {
        WXPayBuilder builder = new WXPayBuilder();
        builder.wxPay = new WXPay(new WechatPayConfig(H5WXPayAccount.APP_ID, H5WXPayAccount.MCH_ID, H5WXPayAccount.APP_KEY, H5WXPayAccount.URL_NOTIFY));
        return builder;
    }

    public static WXPayBuilder newBuilderApp() {
        WXPayBuilder builder = new WXPayBuilder();
        builder.wxPay = new WXPay(new WechatPayConfig("wx4cc8497ce055727b", "1492071272", "1trDGOSOYe8KtSzBmcnWhFayRjsWeQMa", "http://120.78.15.214:29001/api/prod//wechat-pay/asynchronous-notification"));
        return builder;
    }

    public WXPay build() {
        return wxPay;
    }
}
