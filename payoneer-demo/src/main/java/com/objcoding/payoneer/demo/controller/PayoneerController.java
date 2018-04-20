package com.objcoding.payoneer.demo.controller;

import com.objcoding.payoneer.demo.helper.PayoneerHelper;
import com.objcoding.payoneer.model.request.ChargeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/19.
 */
@RestController
@RequestMapping("/payoneer")
public class PayoneerController {

    @Autowired
    private PayoneerHelper payoneerHelper;

    /**
     * 判断授权状态
     *
     * @param payeeId 授权到商户系统里用于标识用户的id，类似于openid
     */
    @PostMapping(value = "/payee/{payeeId}/status/")
    public Map<String, Object> getPayeeStatus(@PathVariable String payeeId) {
        return payoneerHelper.getPayeeStatus(payeeId);
    }

    /**
     * 获取授权地址 类似与 Oauth 授权
     *
     * @param payeeId 授权到商户系统里用于标识用户的id，类似于openid
     * @return 授权url
     */
    @PostMapping("/registration-link/{payeeId}")
    public Map<String, Object> getRegistrationLink(@PathVariable String payeeId) {
        return payoneerHelper.getRegistrationLink(payeeId);
    }

    /**
     * 付款
     *
     * @param request 付款请求对象
     * @return 付款信息
     */
    @PostMapping("/charges")
    public Map<String, Object> charges(@RequestBody ChargeRequest request) {
        return payoneerHelper.charge(request);
    }


    /**
     * 取消付款
     *
     * @param clientReferenceId 付款订单编号
     * @return 取消付款信息
     */
    @PostMapping("/charges/{clientReferenceId}/cancel/")
    public Map<String, Object> cancelCharge(@PathVariable String clientReferenceId) {
        return payoneerHelper.cancelCharge(clientReferenceId);
    }


    // TODO
    /**
     * 授权回调处理
     *
     * @param request
     * @return
     */
    @PostMapping("/authorization-notify")
    public String authorizationNotify(HttpServletRequest request) throws IOException {
        return "";
    }
}
