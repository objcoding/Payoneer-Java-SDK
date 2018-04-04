package com.objcoding.wxpay.config;

import java.io.InputStream;

public interface WXPayConfig {


    /**
     * 获取 App ID
     *
     * @return App ID
     */
    String getAppID();


    /**
     * 获取 Mch ID
     *
     * @return Mch ID
     */
    String getMchID();


    /**
     * 获取 API 密钥
     *
     * @return API密钥
     */
    String getKey();


    /**
     * 获取商户证书内容
     *
     * @return 商户证书内容
     */
    InputStream getCertStream();

    /**
     * HTTP(S) 连接超时时间，单位毫秒
     *
     * @return
     */
    int getHttpConnectTimeoutMs();

    /**
     * HTTP(S) 读数据超时时间，单位毫秒
     *
     * @return
     */
    int getHttpReadTimeoutMs();

    /**
     * 支付回调地址
     *
     * @return
     */
    String getUrlNotify();

}
