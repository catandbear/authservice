package com.catandbear.jwt.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.catandbear.data.UserInfo;

public class TokenTool {

	public static String getToken(UserInfo user) {
        String token="";
        token= JWT.create().withAudience(user.getUserName())
                .sign(Algorithm.HMAC256(user.getPassWord()));
        return token;
    }
}
