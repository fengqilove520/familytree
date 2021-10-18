package top.fqq.familytree.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/**
 * @author fitch
 * @date 2021/10/18 10:48
 */
@Component
public class JwtUtil {

    @Value("${token.expire:1800}")
    private Integer expire;

    /**
     * 签发对象：这个用户的id
     * 签发时间：现在
     * 有效时间：30分钟
     * 载荷内容：暂时设计为：这个人的名字，这个人的昵称
     * 加密密钥：这个人的id加上一串字符串
     */
    public String createToken(String userId, String realName, String userName) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.SECOND, expire);
        Date expiresDate = nowTime.getTime();
        return JWT.create().withAudience(userId)   //签发对象
                .withIssuedAt(new Date())    //发行时间
                .withExpiresAt(expiresDate)  //有效时间
                .withClaim("userName", userName)    //载荷，随便写几个都可以
                .withClaim("realName", realName)
                .sign(Algorithm.HMAC256(userId + "HelloLehr"));   //加密
    }

    /**
     * 检验合法性，其中secret参数就应该传入的是用户的id
     *
     * @param token
     * @throws Exception
     */
    public void verifyToken(String token, String secret) throws Exception {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret + "HelloLehr")).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            //效验失败
            throw e;
        }
    }

    /**
     * 获取签发对象
     */
    public String getAudience(String token) throws Exception {
        String audience = null;
        try {
            audience = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException e) {
            //这里是token解析失败
            throw e;
        }
        return audience;
    }


    /**
     * 通过载荷名字获取载荷的值
     */
    public Claim getClaimByName(String token, String name) {
        return JWT.decode(token).getClaim(name);
    }
}