package io.syd.aum.ucore.exception;

import io.syd.aum.ucore.result.HttpCodeEnum;

/**
 * @description: 系统异常
 * @program: aum
 * @author: yc
 * @date: 2023-03-15 23:22
 **/
public class SysException extends RuntimeException {

//    @java.io.Serial
    private static final long serialVersionUID = 1L;

    private Integer code;

    public SysException(String msg) {
        super(msg);
        this.code = 500;
    }

    public SysException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public SysException(HttpCodeEnum httpCodeEnum) {
        super(httpCodeEnum.getMessageCN());
        this.code = httpCodeEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
