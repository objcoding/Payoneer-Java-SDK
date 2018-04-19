package com.objcoding.payoneer.core;


import com.objcoding.payoneer.model.enums.PayoneerField;
import com.objcoding.payoneer.model.enums.TradeType;

import java.util.HashMap;
import java.util.Map;

import static com.objcoding.payoneer.utils.Preconditions.checkNotNullAndEmpty;

/**
 * payoneer pay 用户状态组件
 * <p>
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/17.
 */
public final class Payees extends Component {

    public Payees(Payoneer payoneer) {
        super(payoneer);
    }

    /**
     * 获取用户授权状态
     *
     * @param payeeId 用户id
     * @return 返回是否认证 true 已认证
     */
    public Map<String, Object> getPayeeStatus(String payeeId) {
        checkPayeeId(payeeId);
        String url = getURL(TradeType.PAYEES_STATUS);
        return doGet(url, payeeId);
    }

    /**
     * 获取授权页面
     *
     * @param payeeId 用户标识id
     * @return Authorization url
     */
    public Map<String, Object> getRegistrationLink(String payeeId) {
        checkPayeeId(payeeId);
        String url = getURL(TradeType.REGISTRATION);
        Map<String, Object> parmas = new HashMap<String, Object>();
        parmas.put(PayoneerField.PAYEEID.field(), payeeId);
        return doPost(url, parmas);
    }

    /**
     * 获取用户信息
     *
     * @param payeeId 用户标识id
     * @return 用户信息
     */
    public Map<String, Object> getPayeeDetails(String payeeId) {
        checkPayeeId(payeeId);
        String url = getURL(TradeType.PAYEES_DETAILS);
        return doGet(url, payeeId);
    }

    private void checkPayeeId(String payeeId) {
        checkNotNullAndEmpty(payeeId, "payeeId");
    }
}
