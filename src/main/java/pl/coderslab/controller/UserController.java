package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.dto.ShopDto;
import pl.coderslab.dto.UserDto;
import pl.coderslab.service.ShopServiceInt;
import pl.coderslab.service.UserServiceInt;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserServiceInt userServiceInt;
    private final ShopServiceInt shopServiceInt;

    public UserController(UserServiceInt userServiceInt, ShopServiceInt shopServiceInt) {
        this.userServiceInt = userServiceInt;
        this.shopServiceInt = shopServiceInt;
    }

    @GetMapping("/form")
    public String getUser(Model model) {
        model.addAttribute("user", new UserDto());
        return "/user/formUser";
    }

    @PostMapping("/form")
    public String addUser(@Valid UserDto user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "error";
        }
        userServiceInt.add(user);
//        return user.toString();
        return "redirect:/user/view";
    }
    @GetMapping("/view")
    public ModelAndView viewAllUser(){
        ModelAndView modelAndView = new ModelAndView("user/viewUser");
        modelAndView.addAllObjects(Map.of("users", userServiceInt.findAll()));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userServiceInt.delete(id);
        return "redirect:/user/view";
    }

    @ModelAttribute("shops")
    public Collection<ShopDto> shops(){
        return shopServiceInt.findAll();
    }
}

