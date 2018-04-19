package com.objcoding.payoneer.core;

import com.objcoding.payoneer.model.enums.TradeType;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

/**
 * payoneer pay 组件抽象类
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/13.
 */
public class Component {

    protected Payoneer payoneer;

    public Component(Payoneer payoneer) {
        this.payoneer = payoneer;
    }

    public Map<String, Object> doPost(String url, Map<String, Object> params) {

        // TODO
        return null;
    }

    public Map<String, Object> doPost(String url, Object... uriVariables) {

        // TODO
        return null;
    }

    public Map<String, Object> doGet(String url, Object... uriVariables) {

        // TODO
        return null;
    }

    private String doExecute(String url, String reqBody, int connectTimeoutMs, int readTimeoutMs) {

        // TODO
        return null;
    }

    /**
     * 构建 basic 请求头
     */
    private String encodeAuthHeader() {
        return Base64.getEncoder()
                .encodeToString((payoneer.getAuthUsername() + ":" + payoneer.getAuthPassword())
                        .getBytes(StandardCharsets.UTF_8));
    }

    protected String getURL(TradeType type) {
        return (payoneer.isTest() ? Payoneer.SANDBOX_DOMAIN : Payoneer.RELEASE_DOMAIN) +
                payoneer.getProgramId() + "/" + type.getMethod();
    }
}
