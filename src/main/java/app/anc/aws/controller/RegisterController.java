package app.anc.aws.controller;

import app.anc.aws.dao.UserDao;
import app.anc.aws.domain.User;
import app.anc.aws.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/")
public class RegisterController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/register")
    public ModelAndView register(ModelAndView model){
        model.setViewName("register");
        return model;
    }

    @PostMapping(value = "/register")
    public ModelAndView register(ModelAndView model, @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addObject("error", bindingResult.getFieldError().getDefaultMessage());
            model.setViewName("register");
            // 如果UserId有值則帶回頁面上
            if(user.getUserId() != null && !user.getUserId().trim().isEmpty()){
                model.addObject("userId",user.getUserId());
            }
            return model;
        }
        try {
            UserDao userDao = new UserDao(user.getUserName(),user.getPassword(),user.getEmail(),user.getUserName());
            UserDao result = userService.save(userDao);
            model.addObject("userId", result.getUserId());
            model.setViewName("login");
        }catch(Exception e){
            log.error("{}",e);
            model.addObject("userId", user.getUserId());
            model.addObject("error", "新增使用者失敗");
            model.setViewName("register");
        }
        return model;
    }
}
