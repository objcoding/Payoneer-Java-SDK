package com.objcoding.payoneer.demo.helper;

import com.objcoding.payoneer.core.Payoneer;
import com.objcoding.payoneer.core.PayoneerBuilder;
import com.objcoding.payoneer.demo.config.AppPayoneerPayConf;
import com.objcoding.payoneer.model.request.ChargeRequest;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/19.
 */
@Component
public class PayoneerHelper {

    private Payoneer payoneer;

    /**
     * 初始化构建器
     */
    @PostConstruct
    private void init() {
        payoneer = PayoneerBuilder
                .newBuilder(
                        AppPayoneerPayConf.PROGRAM_ID,
                        AppPayoneerPayConf.AUTH_USERNAME,
                        AppPayoneerPayConf.AUTH_PASSWORD
                )
                .build();
    }

    // *********************************** Payees ************************************************

    /**
     * 获取用户授权状态
     *
     * @param payeeId 用户标识id
     * @return 授权状态
     */
    public Map<String, Object> getPayeeStatus(String payeeId) {
        return payoneer.payees().getPayeeStatus(payeeId);
    }

    /**
     * 获取授权页面
     *
     * @param payeeId 用户标识id
     * @return 授权页面
     */
    public Map<String, Object> getRegistrationLink(String payeeId) {
        return payoneer.payees().getRegistrationLink(payeeId);
    }

    /**
     * 获取用户信息
     *
     * @param payeeId 用户标识id
     * @return 授权页面
     */
    public Map<String, Object> getPayeeDetails(String payeeId) {
        return payoneer.payees().getPayeeDetails(payeeId);
    }


    // *********************************** charges **********************************************************

    /**
     * 付款
     *
     * @param request 付款请求对象
     * @return 付款信息
     */
    public Map<String, Object> charge(ChargeRequest request) {
        return payoneer.charges().charge(request);
    }

    /**
     * 取消付款
     *
     * @param clientReferenceId 付款订单编号
     * @return 付款信息
     */
    public Map<String, Object> cancelCharge(String clientReferenceId) {
        return payoneer.charges().cancelCharge(clientReferenceId);
    }


    // *********************************** notifies *******************************************************


}
