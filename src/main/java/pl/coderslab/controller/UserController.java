package pl.coderslab.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.dto.ShopDto;
import pl.coderslab.dto.UserAddDto;
import pl.coderslab.dto.UserReadDto;
import pl.coderslab.model.Role;
import pl.coderslab.service.CurrentUser;
import pl.coderslab.service.ShopService;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class UserController {
    private final UserService userService;
    private final ShopService shopService;

    public UserController(UserService userService, ShopService shopService) {
        this.userService = userService;
        this.shopService = shopService;
    }
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

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

    @GetMapping("/view")
    public ModelAndView viewAllUser(@AuthenticationPrincipal CurrentUser currentUser) {
        ModelAndView modelAndView = new ModelAndView("admin/viewUser");
        modelAndView.addAllObjects(Map.of("users", userService.findAllSortedByShop()));
//        List<UserReadDto> userList = userService.findAll();
        System.out.println();
//        System.out.println(userList.toString());
        return modelAndView;
    }

    @GetMapping(value = "/edit", params = "id")
    public String editUser(@RequestParam Long id, Model model) {
        UserReadDto userReadDto = userService.findById(id);
        List<Role> roles = userService.findRoleList();
        model.addAttribute("editUser", userReadDto);
        model.addAttribute("roles", roles);
        return "admin/editUser";
    }

    @PostMapping("/edit")
    public String edutUserPost(@ModelAttribute("editUser") @Valid UserReadDto userReadDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/editUser";
        }
        userService.update(userReadDto);
        return "redirect:/user/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
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

