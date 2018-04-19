package com.objcoding.payoneer.core;

import com.alibaba.fastjson.JSONObject;
import com.objcoding.payoneer.http.HttpRequest;
import com.objcoding.payoneer.model.enums.TradeType;
import com.objcoding.payoneer.utils.UriVariables;
import com.objcoding.payoneer.utils.Util;

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

    public Map<String, Object> doGet(String url, Object... uriVariables) {
        url = UriVariables.getUri(url, uriVariables);
        String basicAuthCode = getBasicAuthCode();
        return this.getRequest(url, basicAuthCode);
    }

    public Map<String, Object> doPost(String url, Map<String, Object> params) {
        String basicAuthCode = getBasicAuthCode();
        String reqBody = JSONObject.toJSONString(params);
        return this.postRequest(url, basicAuthCode, reqBody);
    }

    private Map<String, Object> getRequest(String url, String basicAuthCode) {
        String response = HttpRequest.getRequest(url, basicAuthCode);
        if (response != null) {
            return Util.toMap(response);
        }
        return null;
    }

    private Map<String, Object> postRequest(String url, String basicAuthCode, String reqBody) {
        String response = HttpRequest.postRequest(url, basicAuthCode, reqBody);
        if (response != null) {
            return Util.toMap(response);
        }
        return null;
    }

    /**
     * 构建 basic 请求头
     */
    private String getBasicAuthCode() {
        return "Basic " + Base64.getEncoder()
                .encodeToString((payoneer.getAuthUsername() + ":" + payoneer.getAuthPassword())
                        .getBytes(StandardCharsets.UTF_8));
    }

    protected String getURL(TradeType type) {
        return (payoneer.isTest() ? Payoneer.SANDBOX_DOMAIN : Payoneer.RELEASE_DOMAIN) +
                payoneer.getProgramId() + "/" + type.getMethod();
    }
}
