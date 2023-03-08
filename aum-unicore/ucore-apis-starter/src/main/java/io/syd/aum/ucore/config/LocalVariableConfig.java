package io.syd.aum.ucore.config;

/**
 * @description: 此配置可存在于配置列表中
 * @program: aum
 * @author: yc
 * @date: 2023-03-08 23:13
 **/
public class LocalVariableConfig extends GlobalVariable {
    public static final String LBC_WK_EXP01 = "syd-worker-exp01";
    public static final String LBC_WK_EXP02 = "syd-worker-exp02";

    /**
     * 默认密码 88888888
     */
    public static String DEFAULT_PASS = "88888888";

    /**
     * 日志单次批处理容量
     */
    public static final int DEFAULT_BATCH_SIZE = 64;
}
