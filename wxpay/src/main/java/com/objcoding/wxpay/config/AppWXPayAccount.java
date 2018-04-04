package com.objcoding.wxpay.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@EnableConfigurationProperties(AppWXPayProperties.class)
public class AppWXPayAccount {

    @Autowired
    private AppWXPayProperties appWXPayProperties;

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
        AppWXPayAccount.APP_ID = appWXPayProperties.getAppId();
        AppWXPayAccount.APP_SECRET = appWXPayProperties.getAppSecret();
        AppWXPayAccount.APP_KEY = appWXPayProperties.getAppKey();
        AppWXPayAccount.MCH_ID = appWXPayProperties.getMchId();
        AppWXPayAccount.URL_NOTIFY = appWXPayProperties.getUrlNotify();
    }
}
