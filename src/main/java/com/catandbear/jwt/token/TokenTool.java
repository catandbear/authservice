package com.catandbear.jwt.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.catandbear.data.UserInfoDB;

public class TokenTool {

	public static String getToken(UserInfoDB user) {
        String token="";
        token= JWT.create().withAudience(user.getUser_name())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
