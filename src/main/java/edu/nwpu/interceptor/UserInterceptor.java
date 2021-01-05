package edu.nwpu.interceptor;

import edu.nwpu.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截用户操作
 * @author dengzhijian
 */
public class UserInterceptor implements HandlerInterceptor {

  @Override
  public void afterCompletion(
      HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
      throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void postHandle(
      HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
      throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2)
      throws Exception {
    // 获取session
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("user");
    // 判断session中是否有用户数据，如果有，则返回true，继续向下执行
    if (user != null && user.getName() != null) {
      return true;
    }
    // 不符合条件的转发到登录页面
    response.sendRedirect(request.getContextPath() + "/");
    return false;
  }
}
