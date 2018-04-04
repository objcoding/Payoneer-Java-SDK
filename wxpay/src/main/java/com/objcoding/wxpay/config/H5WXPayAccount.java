package com.objcoding.wxpay.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@EnableConfigurationProperties(H5WXPayProperties.class)
public class H5WXPayAccount {

    @Autowired
    private H5WXPayProperties h5WXPayProperties;

    public static String APP_ID;


    public static String APP_SECRET;

    public static String APP_KEY;

    public static String MCH_ID;  //商户号

    public static String URL_UNIFIED_ORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    public static String URL_REFUND = "https://api.mch.weixin.qq.com/secapi/pay/refund";
// UAT
//  public static String URL_NOTIFY = "http://119.23.151.18:16888/api/prod//wechat-pay/asynchronous-notification";

// PROD

    public static String URL_NOTIFY;

    public static int TIME_EXPIRE = 2;  //单位是day

//    public static String signType;


    @PostConstruct
    public void initConstants() {
        System.out.println("=======================================================");
        H5WXPayAccount.APP_ID = h5WXPayProperties.getAppId();
        H5WXPayAccount.APP_SECRET = h5WXPayProperties.getAppSecret();
        H5WXPayAccount.APP_KEY = h5WXPayProperties.getAppKey();
        H5WXPayAccount.MCH_ID = h5WXPayProperties.getMchId();
        H5WXPayAccount.URL_NOTIFY = h5WXPayProperties.getUrlNotify();
    }

}
