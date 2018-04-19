package com.objcoding.payoneer.utils;

import java.util.UUID;

/**
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/18.
 */
public class RandomUtils {

    /**
     * 获取随机字符串
     *
     * @return 随机字符串
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    }
}
