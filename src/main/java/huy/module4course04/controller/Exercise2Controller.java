package huy.module4course04.controller;

import huy.module4course04.model.Login;
import huy.module4course04.model.User;
import huy.module4course04.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class Exercise2Controller {
    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("exercise2/home");
        modelAndView.addObject("login", new Login());
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = UserService.checkLogin(login);
        ModelAndView modelAndView;
        if(user == null){
            modelAndView = new ModelAndView("error");
        } else {
            modelAndView = new ModelAndView("exercise2/user");
            modelAndView.addObject("user", user);
        }
        return modelAndView;
    }
}
