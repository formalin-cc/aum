package io.syd.aum.ucore.exception;

import io.syd.aum.ucore.result.HttpCodeEnum;


/**
 * @description: 业务异常
 * @program: aum
 * @author: yc
 * @date: 2023-03-15 23:21
 **/
public class BizException extends RuntimeException {

//    @java.io.Serial
    private static final long serialVersionUID = 1L;

    private Integer code;

    public BizException(String msg) {
        super(msg);
        this.code = 500;
    }

    public BizException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public BizException(HttpCodeEnum httpCodeEnum) {
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
