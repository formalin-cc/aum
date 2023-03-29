package io.syd.aum.ucore.utils.authentic;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.*;
import io.syd.aum.ucore.config.GlobalVariable;
import io.syd.aum.ucore.exception.BizException;
import io.syd.aum.ucore.exception.SysException;
import io.syd.aum.ucore.result.HttpCodeEnum;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

/**
 * @description:
 * @program: aum
 * @author: yc
 * @date: 2023-03-29 21:12
 **/
public class JwtUtils {
    /**
     * 验证jwt合法性
     *
     * @param jwt JsonWebToken
     * @return 成功则状态码200并附带SysUser对象
     */
    public static String validateJwt(String jwt) {
        if (StringUtils.isBlank(jwt))
            throw new BizException(HttpCodeEnum.TOKEN_ERR);
        //return Result.tokenError().toString();// 空令牌
        try {
            byte[] bytes = Base64.encodeBase64(GlobalVariable.SECRET_KEY.getBytes(StandardCharsets.UTF_8));
            Claims claims = Jwts.parser()
                    .setSigningKey(bytes)
                    .parseClaimsJws(jwt)
                    .getBody();
            return JSON.toJSONString(claims);
        } catch (ExpiredJwtException e) {// 已过期令牌
            throw new BizException(HttpCodeEnum.AUTH_EXPIRED);
            //return Result.authExpired().toString();
        } catch (SignatureException e) {// 伪造令牌
            throw new BizException(HttpCodeEnum.UNAUTHORIZED);
            // return Result.unAuthorized().toString();
        } catch (Exception e) {// 系统错误
            throw new SysException(HttpCodeEnum.INTERNAL_SERVER_ERROR);
            //return Result.serverError().toString();
        }
    }

    /**
     * 生成JWT，存入 用户名
     *
     * @param name 用户名
     * @return 预设的JWT
     */
    public static String genJWT(String name) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, GlobalVariable.EXPIRE_DAY);
        byte[] bytes = Base64.encodeBase64(GlobalVariable.SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, bytes)// 使用HS256加密算法
                .setExpiration(calendar.getTime())// 过期时间
                .claim("name", name)
                .compact();
    }
}
