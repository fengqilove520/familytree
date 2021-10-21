package top.fqq.familytree.util;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import top.fqq.familytree.bean.ErrorCodeEnum;
import top.fqq.familytree.bean.UserClaim;
import top.fqq.familytree.exception.BizException;

import java.util.Calendar;
import java.util.Date;

/**
 * @author fitch
 * @date 2021/10/18 10:48
 */
@Slf4j
@Component
public class JwtUtil {

    @Value("${token.expire:1800}")
    private Integer expire;

    public final static String CLAIM_KEY = "user";

    /**
     * 签发对象：这个用户的id
     * 签发时间：现在
     * 有效时间：30分钟
     * 载荷内容：暂时设计为：这个人的名字，这个人的昵称
     * 加密密钥：这个人的id加上一串字符串
     */
    public String createToken(String userId, UserClaim userClaim) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.SECOND, expire);
        Date expiresDate = nowTime.getTime();
        return JWT.create().withAudience(userId)   //签发对象
                .withIssuedAt(new Date())//发行时间
                .withExpiresAt(expiresDate)//有效时间
                .withClaim(CLAIM_KEY, JSON.toJSONString(userClaim))
                .sign(Algorithm.HMAC256(userId));   //加密
    }

    /**
     * 检验合法性，其中secret参数就应该传入的是用户的id
     *
     * @param token
     * @throws Exception
     */
    public void verifyToken(String token, String secret) throws Exception {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
            verifier.verify(token);
        } catch (TokenExpiredException e) {
            log.error(e.getMessage(), e);
            //效验失败
            throw new BizException(ErrorCodeEnum.TOKEN_EXPIRED_ERROR);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            //效验失败
            throw new BizException(ErrorCodeEnum.TOKEN_ERROR);
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
