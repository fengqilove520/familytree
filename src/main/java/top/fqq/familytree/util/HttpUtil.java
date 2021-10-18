package top.fqq.familytree.util;

import org.springframework.util.Base64Utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fitch
 * @date 2021/10/18 14:14
 */
public class HttpUtil {

    public static final String COOKIE_PATH = "Lw==";

    /**
     * Cookie中的token key
     */
    public static final String TOKEN = "token";

    /**
     * 获取Cookie
     *
     * @param request 请求
     * @param name    Cookie中的name
     * @return Cookie中对应的value
     */
    public static String getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (name == null || cookies == null) {
            return null;
        }
        for (Cookie cookie : request.getCookies()) {
            if (name.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }

    /**
     * 响应头回写Cookie
     *
     * @param response 响应
     * @param name     Cookie中的name
     * @param value    Cookie中的value
     */
    public static void writeCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath(new String(Base64Utils.decodeFromString(COOKIE_PATH)));
        cookie.setMaxAge(-1);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        response.addCookie(cookie);
    }
}
