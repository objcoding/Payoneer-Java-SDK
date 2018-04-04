package com.objcoding.wxpay.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "h5.wechatpay")
public class H5WXPayProperties {


        private String appId;

        private String appSecret;

        private String appKey;

        private String mchId;

        private String urlNotify;


        public String getAppId() {
                return appId;
        }

        public void setAppId(String appId) {
                this.appId = appId;
        }

        public String getAppSecret() {
                return appSecret;
        }

        public void setAppSecret(String appSecret) {
                this.appSecret = appSecret;
        }

        public String getAppKey() {
                return appKey;
        }

        public void setAppKey(String appKey) {
                this.appKey = appKey;
        }

        public String getMchId() {
                return mchId;
        }

        public void setMchId(String mchId) {
                this.mchId = mchId;
        }

        public String getUrlNotify() {
                return urlNotify;
        }

        public void setUrlNotify(String urlNotify) {
                this.urlNotify = urlNotify;
        }
}
