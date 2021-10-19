package top.fqq.familytree.intercept.jwt;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ObjectUtils;
import org.springframework.util.PathMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.fqq.familytree.bean.ErrorCodeEnum;
import top.fqq.familytree.bean.Subject;
import top.fqq.familytree.bean.SubjectContext;
import top.fqq.familytree.bean.UserClaim;
import top.fqq.familytree.exception.BizException;
import top.fqq.familytree.service.UserService;
import top.fqq.familytree.util.HttpUtil;
import top.fqq.familytree.util.JwtUtil;
import top.fqq.familytree.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fitch
 * @date 2021/10/18 10:57
 */
@Slf4j
public class JwtAuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${token.excludeAuthPath:\"\"}")
    private String excludeAuthPath;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        if (this.matches(httpServletRequest.getRequestURI(), excludeAuthPath)) {
            return true;
        }
        //从请求头中取出token
        String token = HttpUtil.getCookie(httpServletRequest, HttpUtil.TOKEN);
        // 执行认证
        if (StringUtil.isEmpty(token)) {
            throw new BizException(ErrorCodeEnum.TOKEN_ERROR);
        }
        String userId = jwtUtil.getAudience(token);
        UserClaim userClaim = JSON.parseObject(jwtUtil.getClaimByName(token, JwtUtil.CLAIM_KEY).asString(), UserClaim.class);
        Subject subject = new Subject();
        subject.setUserId(userId);
        subject.setUserName(userClaim.getName());
        subject.setFullName(userClaim.getFullName());
        SubjectContext.set(subject);
        // 验证 token
        jwtUtil.verifyToken(token, userId);
        // 颁发新凭证
        token = jwtUtil.createToken(userId, userClaim);
        HttpUtil.writeCookie(httpServletResponse, HttpUtil.TOKEN, token);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }


    /**
     * URL匹配
     *
     * @param lookupPath 待匹配的路径
     * @param path       规则路径
     * @return 匹配结果
     */
    private boolean matches(String lookupPath, String path) {
        if (StringUtil.isEmpty(lookupPath)) {
            return false;
        }
        PathMatcher pathMatcherToUse = new AntPathMatcher();
        String[] paths = path.split(",");
        if (ObjectUtils.isEmpty(paths)) {
            return false;
        }
        for (String pattern : paths) {
            if (pathMatcherToUse.match(pattern, lookupPath)) {
                return true;
            }
        }
        return false;
    }
}
