package com.objcoding.payoneer.utils;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/19.
 */
public class Util {

    /**
     * 元转分
     *
     * @param amount 元的金额
     * @return 分的金额
     */
    public static int converAmount(BigDecimal amount) {
        return amount.multiply(new BigDecimal(100)).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
    }

    /**
     * json to map
     */
    private Map<String, Object> toMap(String response) {
        return JSONObject.parseObject(response, Map.class);
    }
}
