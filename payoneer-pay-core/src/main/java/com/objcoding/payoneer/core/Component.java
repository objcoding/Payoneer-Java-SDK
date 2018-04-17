package com.objcoding.payoneer.core;

import com.alibaba.fastjson.JSONObject;
import com.objcoding.payoneer.model.enums.TradeType;

import java.math.BigDecimal;
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

    protected PayoneerPay payoneerPay;

    public Component(PayoneerPay payoneerPay) {
        this.payoneerPay = payoneerPay;
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

    /**
     * json to map
     */
    private Map<String, Object> toMap(String response) {
        return JSONObject.parseObject(response, Map.class);
    }

    /**
     * 构建 basic 请求头
     */
    private String encodeAuthHeader() {
        return Base64.getEncoder()
                .encodeToString((payoneerPay.getAuthUsername() + ":" + payoneerPay.getAuthPassword())
                        .getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 元转分
     *
     * @param amount 元的金额
     * @return 分的金额
     */
    protected int converAmount(BigDecimal amount) {
        return amount.multiply(new BigDecimal(100)).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
    }

    protected String getURL(TradeType type) {
        return (payoneerPay.isTest() ? PayoneerPay.SANDBOX_DOMAIN : PayoneerPay.RELEASE_DOMAIN) +
                payoneerPay.getProgramId() + "/" + type.getMethod();
    }
}
