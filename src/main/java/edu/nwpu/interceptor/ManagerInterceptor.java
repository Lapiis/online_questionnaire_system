package edu.nwpu.interceptor;

import edu.nwpu.domain.Manager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截管理员操作
 * @author dengzhijian
 */
public class ManagerInterceptor implements HandlerInterceptor {

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
    Manager manager = (Manager) session.getAttribute("manager");
    // 判断session中是否有用户数据，如果有，则返回true，继续向下执行
    if (manager != null && manager.getName() != null) {
      return true;
    }
    // 不符合条件的转发到登录页面
    response.sendRedirect(request.getContextPath() + "/");
    return false;
  }
}
