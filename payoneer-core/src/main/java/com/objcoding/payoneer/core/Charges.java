package com.objcoding.payoneer.core;


import com.objcoding.payoneer.model.enums.PayoneerField;
import com.objcoding.payoneer.model.enums.TradeType;
import com.objcoding.payoneer.model.request.ChargeRequest;
import com.objcoding.payoneer.utils.RandomUtils;

import java.util.HashMap;
import java.util.Map;

import static com.objcoding.payoneer.utils.Preconditions.*;
import static com.objcoding.payoneer.utils.Util.converAmount;

/**
 * Payoneer 付款组件
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/13.
 */
public class Charges extends Component {

    public Charges(Payoneer payoneer) {
        super(payoneer);
    }

    /**
     * 收款
     *
     * @param request 发起支付的订单信息
     * @return 返回支付结果
     */
    public Map<String, Object> charge(ChargeRequest request) {
        checkPayParams(request);
        String url = getURL(TradeType.CHARGE);
        return doPost(url, buildPayParams(request));
    }

    /**
     * 取消收款
     *
     * @param clientReferenceId 订单编号
     * @return 返回支付方申请退款后的结果
     */
    public Map<String, Object> cancelCharge(String clientReferenceId) {
        checkClientReferenceId(clientReferenceId);
        String url = getURL(TradeType.CHARGE_CANCEL);
        Map<String, Object> params = new HashMap<>();
        params.put(PayoneerField.CLIENTREFERENCEID.field(), clientReferenceId);
        return doPost(url, params);
    }

    /**
     * 查询收款订单状态
     *
     * @param clientReferenceId 订单编号
     * @return 收款订单状态
     */
    public Map<String, Object> chargeStatus(String clientReferenceId) {
        checkClientReferenceId(clientReferenceId);
        String url = getURL(TradeType.CHARGE_STATUS);
        Map<String, Object> params = new HashMap<>();
        params.put(PayoneerField.CLIENTREFERENCEID.field(), clientReferenceId);
        return doPost(url, params);
    }

    private void checkClientReferenceId(String clientReferenceId) {
        checkNotNullAndEmpty(clientReferenceId, "clientReferenceId");
    }

    private void checkPayParams(ChargeRequest request) {
        checkNotNull(request, "payoneer pay detail can't be null");
        checkNotNullAndEmpty(request.getPayeeId(), "payeeId");
//        checkNotNullAndEmpty(request.getClientReferenceId(), "clientReferenceId");
        checkNotNullAndEmpty(request.getCurrency(), "currency");
        int amount = converAmount(request.getAmount());
        checkArgument(amount > 0, "totalFee must > 0");
    }

    private Map<String, Object> buildPayParams(ChargeRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(PayoneerField.PAYEEID.field(), request.getPayeeId());
        params.put(PayoneerField.AMOUNT.field(), request.getAmount());
        params.put(PayoneerField.CLIENTREFERENCEID.field(), request.getClientReferenceId() == null ? RandomUtils.randomUUID() : request.getClientReferenceId());
        params.put(PayoneerField.DESCRIPTION.field(), request.getDescription());
        params.put(PayoneerField.CURRENCY.field(), request.getCurrency());
        return params;
    }
}
