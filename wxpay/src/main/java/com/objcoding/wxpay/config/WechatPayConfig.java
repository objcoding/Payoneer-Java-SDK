package com.objcoding.wxpay.config;

import java.io.*;

/**
 * Created by chenghui.zhang on 2018/4/3.
 */
public class WechatPayConfig implements WXPayConfig {

    private byte[] certData;
    private String appId;
    private String mchId;
    private String appKey;
    private String urlNotify;


    public WechatPayConfig(String appId, String mchId, String appKey, String urlNotify) /*throws IOException*/ {

        // 证书
//        String certPath = System.getProperty("user.dir");//服务器根路径，为"tomcat/bin"
//        certPath = certPath.substring(0, certPath.lastIndexOf('/')) + "/path/apiclient_cert.p12";
//        File file = new File(certPath);
//        InputStream certStream = new FileInputStream(file);
//        this.certData = new byte[(int) file.length()];
//        certStream.read(this.certData);
//        certStream.close();

        this.appId = appId;
        this.mchId = mchId;
        this.appKey = appKey;
        this.urlNotify = urlNotify;

    }

    public String getAppID() {
        return appId;//固定参数放在特定的类中
    }

    public String getMchID() {
        return mchId;
    }

    public String getKey() {
        return appKey;
    }

    public InputStream getCertStream() {
        ByteArrayInputStream cretBais = new ByteArrayInputStream(this.certData);
        return cretBais;
    }

    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    public String getUrlNotify() {
        return urlNotify;
    }
}
