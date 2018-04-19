package com.objcoding.payoneer.exception;

/**
 * 支付异常
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/13.
 */
public class PayoneerException extends RuntimeException {

    /**
     * 当支付发生错误时，对应的错误码
     */
    private String errorCode;

    /**
     * 当支付发生错误时，对应的错误消息
     */
    private String errorMsg;

    public PayoneerException(String message) {
        super(message);
    }

    public PayoneerException(String errorCode, String errorMsg) {
        super("[" + errorCode + "]"+ errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
