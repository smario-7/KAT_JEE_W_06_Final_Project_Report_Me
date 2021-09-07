package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.dto.ShopDto;
import pl.coderslab.dto.UserDto;
import pl.coderslab.dto.UserReadDto;
import pl.coderslab.service.ShopService;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final ShopService shopService;

    public UserController(UserService userService, ShopService shopService) {
        this.userService = userService;
        this.shopService = shopService;
    }
    @RequestMapping("/createuser")
    public String createUser(){
        UserDto user = new UserDto();
        user.setEmail("admin@admin.pl");
        user.setPassword("admin");
        userService.add(user);
        return "login";
    }



    @GetMapping("/form")
    public String getUser(Model model) {
        model.addAttribute("user", new UserDto());
        return "/user/formUser";
    }

    @PostMapping("/form")
    public String addUser(@ModelAttribute("user") @Valid UserDto user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/user/formUser";
        }
        userService.add(user);
        return "redirect:/user/view";
    }

    @GetMapping("/view")
    public ModelAndView viewAllUser(){
        ModelAndView modelAndView = new ModelAndView("user/viewUser");
        modelAndView.addAllObjects(Map.of("users", userService.findAll()));
        return modelAndView;
    }

    @GetMapping(value = "/edit", params = "id")
    public String editUser(@RequestParam Long id, Model model){
        UserReadDto userReadDto = userService.findById(id);
        model.addAttribute("editUser", userReadDto);
        return "user/editUser";
    }
    @PostMapping("/edit")
    public String edutUserPost (@ModelAttribute("editUser") @Valid UserReadDto userReadDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "user/editUser";
        }
        userService.update(userReadDto);
        return "redirect:/user/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/user/view";
    }

    @ModelAttribute("shops")
    public Collection<ShopDto> shops(){
        return shopService.findAll();
    }

    @ModelAttribute("headername")
    public String headerName(){
        return "Użytkownik";
    }
}

