package pl.coderslab.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.ShopDto;
import pl.coderslab.dto.UserAddDto;
import pl.coderslab.service.CurrentUser;
import pl.coderslab.service.ShopService;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final ShopService shopService;

    public UserController(UserService userService, ShopService shopService) {
        this.userService = userService;
        this.shopService = shopService;
    }

    // add first user
//    @RequestMapping("/createuser")
//    public String createUser(){
//        UserDto user = new UserDto();
//        user.setEmail("admin@admin.pl");
//        user.setPassword("123456");
//        user.setShopId(1L);
//        userService.add(user);
//        return "login";
//    }


    @GetMapping("/form")
    public String getUser(Model model) {
        model.addAttribute("user", new UserAddDto());
        return "user/formUser";
    }

    @PostMapping("/form")
    public String addUser(@ModelAttribute("user") @Valid UserAddDto user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/formUser";
        }
        userService.add(user);
        return "redirect:/user/view";
    }


    @ModelAttribute("shops")
    public Collection<ShopDto> shops() {
        return shopService.findAll();
    }

    @ModelAttribute("headername")
    public String headerName() {
        return "Użytkownik";
    }

    @ModelAttribute("basicUserData")
    public String[] basicUserData(@AuthenticationPrincipal CurrentUser currentUser) {
        return new String[]{currentUser.getUsername(), currentUser.getUser().getFirstName(), currentUser.getUser().getShop().getShopName()};
    }

}

