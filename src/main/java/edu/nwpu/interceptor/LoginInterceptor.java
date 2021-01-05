package edu.nwpu.interceptor;

import edu.nwpu.domain.User;
import edu.nwpu.service.UserService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截实现自动登录
 * @author dengzhijian
 * @version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

  @Resource private UserService userService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    User loginUser = (User) request.getSession().getAttribute("user");

    if (loginUser == null) {
      String loginCookieUserName = "";
      String loginCookiePassword = "";

      Cookie[] cookies = request.getCookies();
      if (null != cookies) {
        for (Cookie cookie : cookies) {
          if ("loginUserName".equals(cookie.getName())) {
            loginCookieUserName = cookie.getValue();
          } else if ("loginPassword".equals(cookie.getName())) {
            loginCookiePassword = cookie.getValue();
          }
        }
        if (!"".equals(loginCookieUserName) && !"".equals(loginCookiePassword)) {
          User user = userService.findByName(loginCookieUserName);
          if (loginCookiePassword.equals(user.getPassword())) {
            request.getSession().setAttribute("user", user);
          }
        }
      }
    }
    return true;
  }

  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView modelAndView)
      throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void afterCompletion(
      HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    // TODO Auto-generated method stub

  }
}
