package com.objcoding.payoneer.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/19.
 */
@ConfigurationProperties(prefix = "payoneer")
public class AppPayoneerPayProperties {

    private String authUsername;

    private String authPassword;

    private String programId;

    private boolean isTest;

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

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public boolean isTest() {
        return isTest;
    }

    public void setTest(boolean test) {
        isTest = test;
    }
}
