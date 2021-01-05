package edu.nwpu.controller;

import edu.nwpu.domain.User;
import edu.nwpu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author Zhou yuang 用户显示相关页面控制器
 * @version 2.1
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 进入用户登录页面
     *
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "user_login";
    }

    /**
     * 判断用户登录,实现自动登录
     *
     * @param name     用户名
     * @param password 密码
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String doLogin(
            @RequestParam(value = "autoLoginTimeout", defaultValue = "0") int autoLoginTimeout,
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "password", defaultValue = "") String password,
            HttpSession session,
            HttpServletResponse response) {
        User user = userService.login(name, password);
        if (user != null) {
            session.setAttribute("user", user);
            if (autoLoginTimeout > 0) {
                // 自动登录cookie
                Cookie userNameCookie = new Cookie("loginUserName", user.getName());
                Cookie passwordCookie = new Cookie("loginPassword", user.getPassword());
                userNameCookie.setMaxAge(autoLoginTimeout);
                userNameCookie.setPath("/");
                passwordCookie.setMaxAge(autoLoginTimeout);
                passwordCookie.setPath("/");
                response.addCookie(userNameCookie);
                response.addCookie(passwordCookie);
            }
            return "redirect:/user/main";
        } else {
            return "login_error";
        }
    }

    /**
     * 进入用户主界面
     *
     * @return
     */
    @RequestMapping("/main")
    public String main() {
        return "user_main";
    }

    /**
     * 跳转到用户注册界面
     *
     * @param model
     * @return
     */
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute(new User());
        return "user_register";
    }

    /**
     * 处理用户注册
     *
     * @param user
     * @param errors
     * @param session
     * @return
     */
    @PostMapping("/register")
    public String doRegister(@Valid User user, Errors errors, HttpSession session) {
        if (errors.hasErrors()) {
            return "user_register";
        }
        if (userService.checkName(user.getName())) {
            return "register_error";
        }
        session.setAttribute("user", user);
        userService.add(user);
        return "redirect:/user/main";
    }

    /**
     * 跳转到用户个人信息界面
     *
     * @return
     */
    @GetMapping("/info")
    public String info(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "user_info";
    }

    /**
     * 处理用户个人信息修改
     *
     * @param user
     * @param errors
     * @return
     */
    @PostMapping("/info")
    public String doInfo(@Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return "user_info";
        }
        userService.add(user);
        return "redirect:/user/main";
    }

    /**
     * 用户注销
     *
     * @param session
     * @return
     */
    @GetMapping(value = "/logout")
    public String logout(HttpSession session, HttpServletResponse response, Model model) {
        User loginUser = (User) session.getAttribute("user");
        session.removeAttribute("user");
        session.invalidate();
        // 删除登录cookie
        Cookie userNameCookie = new Cookie("loginUserName", loginUser.getName());
        Cookie passwordCookie = new Cookie("loginPassword", loginUser.getPassword());
        userNameCookie.setMaxAge(0);
        userNameCookie.setPath("/");
        passwordCookie.setMaxAge(0);
        passwordCookie.setPath("/");
        response.addCookie(userNameCookie);
        response.addCookie(passwordCookie);
        return "redirect:/";
    }
}
