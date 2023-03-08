package io.syd.aum.ucore.config;

import com.alibaba.fastjson.TypeReference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @program: aum
 * @author: yc
 * @date: 2023-03-08 23:13
 **/
public class GlobalVariable {
    public static TypeReference<Map<String, String>> MAP_SS = new TypeReference<Map<String, String>>() {
    };
    public static TypeReference<Map<String, Object>> MAP_SO = new TypeReference<Map<String, Object>>() {
    };
    public static TypeReference<List<Map<String, String>>> LIST_MAP_SS = new TypeReference<List<Map<String, String>>>() {
    };
    public static TypeReference<List<Map<String, Object>>> LIST_MAP_SO = new TypeReference<List<Map<String, Object>>>() {
    };

    /**
     * 统一版本号
     * <p>
     * 版本不低于1.0.0-BASE时，启用密文验证
     */
    public static String VERSION = "0.0.1-beta";

    /**
     * 权限检查是否打开，默认开
     */
    public static boolean CHECK_AUTH = true;

    /**
     * 静态盐值
     */
    public static String STATIC_SALT = "defaultSalt";
    /**
     * 安全密钥，16位 AES | JWT
     */
    public final static String SECRET_KEY = "ABCDABCDABCDABCD";
    /**
     * JWT过期时间天数
     */
    public final static int EXPIRE_DAY = 7;

    /**
     * 角色中 id 与 name 的映射
     */
    public static Map<Integer, String> ROLE_WITH_NAME = new HashMap<>();


    /**
     * 数据同步标记
     */
    public static boolean DATA_SYNC = true;
    //TODO 此处需要扩展数据同步标记
    public static Map<String, Boolean> DATA_SYNCS = new HashMap<String, Boolean>() {{
        put("USER_INFO", true);
        put("GATEWAY_INFO", true);
    }};


}
