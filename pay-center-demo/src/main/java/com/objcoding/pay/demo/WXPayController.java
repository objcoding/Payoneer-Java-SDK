package com.objcoding.pay.demo;

import com.objcoding.wxpay.core.WXPay;
import com.objcoding.wxpay.core.WXPayBuilder;
import com.objcoding.wxpay.core.WXPayUtil;
import com.objcoding.wxpay.model.WXPayRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenghui.zhang on 2018/4/2.
 */
@RestController
@RequestMapping("/pay/wechat")
public class WXPayController {

    /**
     * 微信统一下单
     *
     * @param payRequest
     * @return
     */
    @RequestMapping(value = "/unified-order")
    public Object pay(@RequestBody WXPayRequest payRequest) {
        Map<String, String> result = new HashMap<String, String>();
        try {
            result = WXPayBuilder.newBuilderApp().build().unifiedOrder(WXPayUtil.buildOrder(payRequest));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }




}
