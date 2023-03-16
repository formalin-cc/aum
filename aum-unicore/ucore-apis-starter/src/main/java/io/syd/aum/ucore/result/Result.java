package io.syd.aum.ucore.result;

/**
 * @description: accumulate
 * @program: aum
 * @author: yc
 * @date: 2023-03-16 22:38
 **/
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    /**
     * 不建议使用
     */
    Result() {
        this(200, null, null);
    }

    /**
     * 不建议使用
     */
    Result(T data) {
        this(200, null, data);
    }

    /**
     * 不建议使用
     */
    public Result(int code, String msg) {
        this(code, msg, null);
    }

    /**
     * 不建议使用
     */
    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 推荐使用
     *
     * @param httpCodeEnum Http状态枚举
     */
    public Result(HttpCodeEnum httpCodeEnum) {
        this(httpCodeEnum.getCode(), httpCodeEnum.getMessageCN());
    }

    /**
     * 推荐使用
     *
     * @param httpCodeEnum Http状态枚举
     * @param data         实体数据
     */
    Result(HttpCodeEnum httpCodeEnum, T data) {
        this(httpCodeEnum.getCode(), httpCodeEnum.getMessageCN(), data);
    }

    /**
     * 请求已经成功处理
     *
     * @param <T> 泛型
     * @return Result
     */
    public static <T> Result<T> success() {
        return new Result<>(HttpCodeEnum.OK);
    }

    /**
     * 请求已经成功处理
     *
     * @param data 实体数据
     * @param <T>  泛型
     * @return Result
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(HttpCodeEnum.OK, data);
    }

    /**
     * 服务器内部错误
     *
     * @param <T> 泛型
     * @return Result
     */
    public static <T> Result<T> fail() {
        return new Result<>(HttpCodeEnum.INTERNAL_SERVER_ERROR);
    }

    /**
     * 服务器内部错误
     *
     * @param data 实体数据
     * @param <T>  泛型
     * @return Result
     */
    public static <T> Result<T> fail(T data) {
        return new Result<>(HttpCodeEnum.INTERNAL_SERVER_ERROR, data);
    }

    /**
     * 请求错误，请修正请求
     *
     * @param <T> 泛型
     * @return Result
     */
    public static <T> Result<T> paramError() {
        return new Result<>(HttpCodeEnum.BAD_REQUEST);
    }

    /**
     * 请求错误，请修正请求
     *
     * @param data 实体数据
     * @param <T>  泛型
     * @return Result
     */
    public static <T> Result<T> paramError(T data) {
        return new Result<>(HttpCodeEnum.BAD_REQUEST, data);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public Result<T> buildCode(int code) {
        this.code = code;
        return this;
    }

    public Result<T> buildMessage(String msg) {
        this.msg = msg;
        return this;
    }

    public Result<T> buildData(T obj) {
        this.data = obj;
        return this;
    }


}
