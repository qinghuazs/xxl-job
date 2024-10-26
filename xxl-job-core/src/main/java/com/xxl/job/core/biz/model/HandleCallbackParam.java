package com.xxl.job.core.biz.model;

import java.io.Serializable;

/**
 * 用于封装任务执行后的回调参数。当一个任务在执行器上执行完毕后，执行器会将任务的执行结果通过回调机制发送给调度中心（Admin），这个过程中就会用到 HandleCallbackParam 类来传递回调信息。
 */
public class HandleCallbackParam implements Serializable {
    private static final long serialVersionUID = 42L;

    /**
     * 任务日志的唯一标识符，用于在调度中心（Admin）中唯一确定一个任务执行日志记录。
     */
    private long logId;
    /**
     * 任务的触发时间，通常是一个时间戳，表示任务何时被触发执行。
     */
    private long logDateTim;
    /**
     * 处理结果 code
     */
    private int handleCode;
    /**
     *  处理结果信息
     */
    private String handleMsg;

    public HandleCallbackParam(){}
    public HandleCallbackParam(long logId, long logDateTim, int handleCode, String handleMsg) {
        this.logId = logId;
        this.logDateTim = logDateTim;
        this.handleCode = handleCode;
        this.handleMsg = handleMsg;
    }

    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    public long getLogDateTim() {
        return logDateTim;
    }

    public void setLogDateTim(long logDateTim) {
        this.logDateTim = logDateTim;
    }

    public int getHandleCode() {
        return handleCode;
    }

    public void setHandleCode(int handleCode) {
        this.handleCode = handleCode;
    }

    public String getHandleMsg() {
        return handleMsg;
    }

    public void setHandleMsg(String handleMsg) {
        this.handleMsg = handleMsg;
    }

    @Override
    public String toString() {
        return "HandleCallbackParam{" +
                "logId=" + logId +
                ", logDateTim=" + logDateTim +
                ", handleCode=" + handleCode +
                ", handleMsg='" + handleMsg + '\'' +
                '}';
    }

}
