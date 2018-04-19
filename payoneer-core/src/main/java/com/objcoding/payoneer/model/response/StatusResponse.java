package com.objcoding.payoneer.model.response;

/**
 * 状态响应对象
 *
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/18.
 */
public class StatusResponse extends Response {


    private int auditId;

    /**
     * 响应编码
     */
    private int code;

    /**
     * 详情
     */
    private String description;

    /**
     * 状态
     */
    private String status;

    public int getAuditId() {
        return auditId;
    }

    public void setAuditId(int auditId) {
        this.auditId = auditId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
