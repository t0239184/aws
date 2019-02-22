package app.anc.aws.controller;

import app.anc.aws.code.PagePath;
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
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * Login 登入頁面導向
     */
    @GetMapping(value = "/")
    public ModelAndView root(ModelAndView model){
        model.setViewName(PagePath.LOGIN.path);
        return model;
    }

    /**
     * Login 登入頁面導向
     */
    @GetMapping(value = "/login")
    public ModelAndView login(ModelAndView model){
        model.setViewName(PagePath.LOGIN.path);
        return model;
    }

    @PostMapping(value = "/login")
    public ModelAndView login(ModelAndView model, @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            model.addObject("error", bindingResult.getFieldError().getDefaultMessage());
            model.setViewName(PagePath.LOGIN.path);
            // 如果UserId有值則帶回頁面上
            if(user.getUserId() != null && !user.getUserId().trim().isEmpty()){
                model.addObject("userId",user.getUserId());
            }
            return model;
        }
        String userId = user.getUserId();
        String password = Integer.toString(user.getPassword().hashCode());

        // TODO Call UserService.findUserById
        UserDao userdao = userService.findUserByUserId(userId);
        if(userdao == null){
            model.addObject("error","無此使用者！");
            model.setViewName(PagePath.LOGIN.path);
            return model;
        }
        if(!password.equals(userdao.getPassword())){
            model.addObject("error","密碼錯誤！");
            model.setViewName(PagePath.LOGIN.path);
            return model;
        }
        //------------------------------------------------------------------------
//        if(!"admin".equals(userId)){
//            model.addObject("error","無此使用者！");
//            model.setViewName(PagePath.LOGIN.path);
//            return model;
//        }
//        if(!"123456".equals(password)){
//            model.addObject("error","密碼錯誤！");
//            model.setViewName(PagePath.LOGIN.path);
//            return model;
//        }
        //------------------------------------------------------------------------

        model.addObject("userId","Hi," + userId);
        model.setViewName(PagePath.LOG_SUCCESS.path);
        return model;
    }

}
