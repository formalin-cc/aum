package io.syd.aum.ucore.utils.authentic;

import io.syd.aum.ucore.config.GlobalVariable;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * @description:
 * @program: aum
 * @author: yc
 * @date: 2023-03-29 21:11
 **/
public class CryptUtil {

    /**
     * 加密前端传输内容
     * <p>
     * 此处由Web页面实现
     *
     * @param content 明文
     * @return 传给页面的密文
     */
    public static String encryptWebPassword(String content) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(GlobalVariable.SECRET_KEY.getBytes(), "AES"));
            byte[] b = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
            // 采用base64算法进行转码,避免出现中文乱码
            return Base64.encodeBase64String(b);
        } catch (Exception e) {
            System.out.println("加密失败：" + e.getMessage());
        }
        return "FAIL:" + content;
    }

    /**
     * 解密前端传输内容
     *
     * @param encryptStr 页面传来的密文
     * @return 明文
     */
    public static String decryptWebPassword(String encryptStr) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(GlobalVariable.SECRET_KEY.getBytes(), "AES"));
            // 采用base64算法进行转码,避免出现中文乱码
            byte[] encryptBytes = Base64.decodeBase64(encryptStr);
            byte[] decryptBytes = cipher.doFinal(encryptBytes);
            return new String(decryptBytes);
        } catch (Exception e) {
            System.out.println("解密失败：" + e.getMessage());
            return "";
        }
    }
}

