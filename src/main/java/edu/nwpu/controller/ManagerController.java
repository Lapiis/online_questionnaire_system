package edu.nwpu.controller;

import edu.nwpu.domain.Manager;
import edu.nwpu.domain.User;
import edu.nwpu.service.ManagerService;
import edu.nwpu.service.QuestionnaireService;
import edu.nwpu.service.UserService;
import edu.nwpu.util.PaginationSupport;
import edu.nwpu.util.URLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 管理员控制器
 *
 * @author dengzhijian
 * @version 2.1
 */
@Controller
@RequestMapping("/manage")
public class ManagerController {
  @Autowired private ManagerService managerService;
  @Autowired private UserService userService;
  @Autowired private QuestionnaireService questionnaireService;

  /**
   * 进入管理员登录页面
   *
   * @param name
   * @param password
   * @param model
   * @param request
   * @return
   */
  @GetMapping("/login")
  public String login(String name, String password, Model model, HttpServletRequest request) {
    return "manager_login";
  }

  /**
   * 管理员登录处理
   *
   * @param name
   * @param password
   * @param session
   * @return
   */
  @PostMapping("/login")
  public String doLogin(
      @RequestParam(value = "name", defaultValue = "") String name,
      @RequestParam(value = "password", defaultValue = "") String password,
      HttpSession session) {
    Manager manager = managerService.login(name, password);
    if (manager != null) {
      session.setAttribute("manager", manager);
      return "redirect:/manage/main";
    } else {
      return "login_error";
    }
  }

  /**
   * 进入管理员主页
   *
   * @return
   */
  @GetMapping("/main")
  public String main() {
    return "manager_main";
  }

  /**
   * 管理员注销
   *
   * @param session
   * @return
   */
  @GetMapping("/logout")
  public String doLogout(HttpSession session) {
    session.removeAttribute("manager");
    session.invalidate();
    return "redirect:/";
  }

  /**
   * 跳转到管理员注册界面
   *
   * @param model
   * @return
   */
  @GetMapping("/register")
  public String register(Model model) {
    model.addAttribute("newManager", new Manager());
    return "manager_register";
  }

  /**
   * 处理管理员注册
   *
   * @param manager
   * @param errors
   * @param session
   * @return
   */
  @PostMapping("/register")
  public String doRegister(@Valid Manager manager, Errors errors, HttpSession session) {
    if (errors.hasErrors()) {
      return "manager_register";
    }
    if (managerService.checkName(manager.getName())) {
      return "register_error";
    }
    managerService.add(manager);
    return "redirect:/manage/managerList";
  }

  /**
   * 管理员信息页
   *
   * @param id
   * @param model
   * @return
   */
  @GetMapping("/infoM/{id}")
  public String info(@PathVariable int id, Model model) {
    Manager manager = managerService.findOne(id);
    model.addAttribute("managerInfo", manager);
    return "manager_info";
  }

  /**
   * 处理管理员个人信息修改
   *
   * @param manager
   * @param errors
   * @return
   */
  @PostMapping("/infoM/{id}")
  public String doInfo(
      @Valid @ModelAttribute("managerInfo") Manager manager, Errors errors, Model model) {
    if (errors.hasErrors()) {
      model.addAttribute("managerInfo", manager);
      return "manager_info";
    }
    managerService.modify(manager);
    return "redirect:/manage/main";
  }

  /**
   * 删除指定管理员
   *
   * @param id
   * @param session
   * @return
   */
  @GetMapping("/deleteM/{id}")
  public String deleteM(@PathVariable int id, HttpSession session) {
    Manager manager = (Manager) session.getAttribute("manager");
    if (manager.getId() == id) {
      return "delete_error";
    }
    managerService.delete(id);
    return "redirect:/manage/managerList";
  }
  /**
   * 分页获取管理员列表
   *
   * @param pageNo
   * @param pageSize
   * @param model
   * @param session
   * @return
   */
  @GetMapping("/managerList")
  public String mList(
      @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
      Model model,
      HttpSession session) {
    PaginationSupport<Manager> mList = managerService.findPage(pageNo, pageSize);
    model.addAttribute("managerList", mList);
    return "manager_mList";
  }

  /**
   * 分页获取用户列表
   *
   * @param pageNo
   * @param pageSize
   * @param model
   * @param session
   * @return
   */
  @GetMapping("/userList")
  public String uList(
      @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
      Model model,
      HttpSession session) {
    PaginationSupport<User> uList = userService.findPage(pageNo, pageSize);
    model.addAttribute("userList", uList);
    return "manager_uList";
  }

  /**
   * 删除指定用户
   *
   * @param id 用户id
   * @return
   */
  @GetMapping("/deleteU/{id}")
  public String deleteU(@PathVariable int id) {
    userService.delete(id);
    return "redirect:/manage/userList";
  }

  /**
   * 重置用户密码
   *
   * @param id
   * @return
   */
  @GetMapping("/resetU/{id}")
  public String resetU(@PathVariable int id) {
    User user = userService.findOne(id);
    user.setPassword("123456");
    userService.modify(user);
    return "reset_success";
  }

  /**
   * 根据用户id，展示用户信息
   *
   * @param id
   * @return
   */
  @GetMapping("/infoU/{id}")
  public String infoU(@PathVariable int id, Model model) {
    User user = userService.findOne(id);
    model.addAttribute("user", user);
    return "manager_uInfo";
  }

  /**
   * 根据用户id，展示用户信息
   *
   * @param user
   * @param errors
   * @return
   */
  @PostMapping("/infoU/{id}")
  public String doInfoU(@Valid User user, Errors errors, Model model) {
    if (errors.hasErrors()) {
      model.addAttribute("user", user);
      return "manager_uInfo";
    }
    userService.add(user);
    return "redirect:/manage/userList";
  }

  /**
   * 审核通过该篇文章
   *
   * @param id 文章
   * @return
   */
  @GetMapping("/checkQ/{id}")
  public String checkQ(@PathVariable int id, @RequestParam int mid) {
    String url = URLUtil.generateUrl(id);
    questionnaireService.setCheck(id, mid, url);
    return "redirect:/manage/questionnaire/questionnaireList";
  }

  /**
   * 删除指定问卷
   *
   * @param id
   * @return
   */
  @GetMapping("/deleteQ/{id}")
  public String deleteQ(@PathVariable int id) {
    questionnaireService.delete(id);
    return "redirect:/manage/questionnaire/questionnaireList";
  }
}
