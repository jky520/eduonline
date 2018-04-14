package com.hx.edu.core.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt加密和解密
 * Created by DT人 on 2018/4/11 10:53.
 */
public class JwtToken {
    /**
     * 公用秘钥-保存在服务端，客户端不会知道秘钥，以防攻击
     */
    public static String SECRET = "@DT人";

    public static String createToken() throws Exception {
        // 签发时间
        Date iatDate = new Date();

        // 过期时间-1分钟过期
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 1);
        Date expiresDate = nowTime.getTime();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("type", "JWT");
        String token = JWT.create()
                .withHeader(map)  // header
                .withClaim("username", "jky") // payload
                .withExpiresAt(expiresDate) // 设置过期时间-过期时间要大于签发时间
                .withIssuedAt(iatDate)  // 签发时间
                .sign(Algorithm.HMAC256(SECRET)); // 加密
        return token;
    }

    public static Map<String, Claim> verifyToken(String token) throws Exception {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = null;
        try {
            jwt = verifier.verify(token);
        } catch (Exception e) {
             throw new RuntimeException("登录凭证已过期，请重新登录");
        }
        return jwt.getClaims();
    }
}
