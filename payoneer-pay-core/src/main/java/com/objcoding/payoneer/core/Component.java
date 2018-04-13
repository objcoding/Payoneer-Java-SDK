package com.objcoding.payoneer.core;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 组件抽象类
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/13.
 */
public class Component {

    public String doPost(String url) {
        return "";
    }

    public String doGet(String url) {
        return "";
    }


    /**
     * 构造Basic Auth认证头信息
     */
    private String getAuthHeader(String userName, String apiPassword) {
        String auth = userName + ":" + apiPassword;
        return Base64.getEncoder().encodeToString((auth).getBytes(StandardCharsets.UTF_8));
    }
}
