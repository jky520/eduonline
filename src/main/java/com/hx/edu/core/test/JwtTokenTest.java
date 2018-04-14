package com.hx.edu.core.test;

import com.auth0.jwt.interfaces.Claim;
import com.hx.edu.core.utils.JwtToken;

import java.util.Map;

/**
 * Created by DT人 on 2018/4/11 11:14.
 */
public class JwtTokenTest {
    public static void main(String[] args) throws Exception {
        String token = JwtToken.createToken();
        System.out.println("Token:"+token);

        Map<String,Claim> claims = JwtToken.verifyToken(token);
        System.out.println(claims.get("username").asString());


        // 使用过期的token验证
        String tokenExpire = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYiLCJ0eXAiOiJKV1QifQ.eyJleHAiOjE1MjM0MTY3MDYsImlhdCI6MTUyMzQxNjY0NiwidXNlcm5hbWUiOiJqa3kifQ.5ZGFucxkr5Wh1aV3wgvStq1FZ_zD41UlGN8g5wdEKTc";
        Map<String,Claim> claimsExpire = JwtToken.verifyToken(tokenExpire);
    }
}
