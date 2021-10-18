package top.fqq.familytree.intercept.jwt;

import com.auth0.jwt.interfaces.Claim;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ObjectUtils;
import org.springframework.util.PathMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.fqq.familytree.bean.Subject;
import top.fqq.familytree.bean.SubjectContext;
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
        if (token == null) {
            //这里其实是登录失效,没token了   这个错误也是我自定义的，读者需要自己修改
            throw new BizException();
        }
        String userId = jwtUtil.getAudience(token);
        Claim userName = jwtUtil.getClaimByName(token, "userName");
        Subject subject = new Subject();
        subject.setUserId(userId);
        subject.setUserName(userName.asString());
        SubjectContext.set(subject);
        // 验证 token
        jwtUtil.verifyToken(token, userId);
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
