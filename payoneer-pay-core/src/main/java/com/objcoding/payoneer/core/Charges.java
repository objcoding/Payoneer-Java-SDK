package com.objcoding.payoneer.core;


import com.objcoding.payoneer.model.ChargeRequest;
import com.objcoding.payoneer.model.enums.PayoneerPayField;
import com.objcoding.payoneer.model.enums.TradeType;

import java.util.HashMap;
import java.util.Map;

import static com.objcoding.payoneer.utils.Preconditions.checkArgument;
import static com.objcoding.payoneer.utils.Preconditions.checkNotNullAndEmpty;

/**
 * Payoneer 付款组件
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/13.
 */
public class Charges extends Component {

    public Charges(PayoneerPay payoneerPay) {
        super(payoneerPay);
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
        return doPost(url, clientReferenceId);
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
        return doPost(url, clientReferenceId);
    }

    private void checkClientReferenceId(String clientReferenceId) {
        checkNotNullAndEmpty(clientReferenceId, "clientReferenceId");
    }

    private void checkPayParams(ChargeRequest request) {
        checkNotNull(request, "payoneer pay detail can't be null");
        checkNotNullAndEmpty(request.getPayeeId(), "payeeId");
        checkNotNullAndEmpty(request.getClientReferenceId(), "clientReferenceId");
        checkNotNullAndEmpty(request.getCurrency(), "clientReferenceId");
        int amount = converAmount(request.getAmount());
        checkArgument(amount > 0, "totalFee must > 0");
    }

    private void checkNotNull(ChargeRequest request, String s) {
    }

    private Map<String, Object> buildPayParams(ChargeRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put(PayoneerPayField.PAYEEID.field(), request.getPayeeId());
        params.put(PayoneerPayField.AMOUNT.field(), request.getAmount());
        params.put(PayoneerPayField.CLIENTREFERENCEID.field(), request.getClientReferenceId());
        params.put(PayoneerPayField.DESCRIPTION.field(), request.getDescription());
        params.put(PayoneerPayField.CURRENCY.field(), request.getCurrency());
        return params;
    }
}
