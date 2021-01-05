package edu.nwpu.controller;

import edu.nwpu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页面控制器
 *
 * @author dengzhijian
 * @version 2.1
 */
@Controller
@RequestMapping("/")
public class HomeController {
  @Autowired private UserService userService;

  /**
   * 跳转到主页
   *
   * @return
   */
  @GetMapping
  public String home() {
    return "home";
  }
}
