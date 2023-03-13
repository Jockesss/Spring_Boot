package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserServiceImp;


@Controller

public class UserController {
    @Autowired
    private UserServiceImp userService;


    @RequestMapping(value = "/")
    public ModelAndView viewUsers(Model model){
        model.addAttribute("users",userService.getUsersList());
        return new ModelAndView("index");
    }
    @RequestMapping("/add")
    public ModelAndView addUser(Model model){
        User user = new User();
        if ((user.getName() != "") && (user.getLastName() != "")) {
            model.addAttribute("user", user);
        }
        return new ModelAndView("add_user");
    }
    @RequestMapping("/register")
    public ModelAndView getNewUserForm(@ModelAttribute("user") User user) {
        if ((user.getName() != "") && (user.getLastName() != "")) {
            userService.addUser(user);
        }
        return new ModelAndView("redirect:/");
    }


    @GetMapping("/edit/{id}")
        public ModelAndView getFormUserUpdate(Model model,@PathVariable("id") String userId){
            try {
                User edittableuser = userService.getUserById(Long.parseLong(userId));
                model.addAttribute("edittableuser",edittableuser);
                return new ModelAndView("user_edit");
            } catch (NumberFormatException e) {
                return new ModelAndView("/");
            }
        }

        @PostMapping("/edit")
        public ModelAndView saveEditUser (@ModelAttribute("edittableuser") User edittableuser){
            try {
                userService.updateUser(edittableuser);
                return new ModelAndView("redirect:/");
            } catch (NumberFormatException e) {
                return new ModelAndView("/");
            }

        }

        @RequestMapping("/delete/{id}")
        public ModelAndView deleteUser(@PathVariable("id") String userId){
            userService.deleteUser(Long.parseLong(userId));
            return new ModelAndView("redirect:/");
        }
}
