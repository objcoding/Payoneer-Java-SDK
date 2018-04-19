package com.objcoding.payoneer.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/19.
 */
@Configuration
@EnableConfigurationProperties(AppPayoneerPayProperties.class)
public class AppPayoneerPayConf {

    @Autowired
    private AppPayoneerPayProperties appPayoneerPayProperties;

    public static String PROGRAM_ID; // 商户识别码

    public static String AUTH_USERNAME; // 商户账户名

    public static String AUTH_PASSWORD; // api password

    public static boolean IS_TEST;

    @PostConstruct
    public void initConstants() {
        AppPayoneerPayConf.PROGRAM_ID = appPayoneerPayProperties.getProgramId();
        AppPayoneerPayConf.AUTH_USERNAME = appPayoneerPayProperties.getAuthUsername();
        AppPayoneerPayConf.AUTH_PASSWORD = appPayoneerPayProperties.getAuthPassword();
        AppPayoneerPayConf.IS_TEST = appPayoneerPayProperties.isTest();
    }

}
