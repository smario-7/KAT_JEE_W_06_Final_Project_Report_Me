package pl.coderslab.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.dto.ShopDto;
import pl.coderslab.dto.UserEditRoleDto;
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
public class AdminController {
    private final UserService userService;
    private final ShopService shopService;

    public AdminController(UserService userService, ShopService shopService) {
        this.userService = userService;
        this.shopService = shopService;
    }

    @GetMapping("/view")
    public ModelAndView viewAllUser(@AuthenticationPrincipal CurrentUser currentUser) {
        ModelAndView modelAndView = new ModelAndView("admin/viewUser");
        modelAndView.addAllObjects(Map.of("users", userService.findAllSortedByShop()));
        return modelAndView;
    }

    @GetMapping(value = "/edit", params = "id")
    public String editUser(@RequestParam Long id, Model model) {
        UserEditRoleDto userEditRoleDto = userService.findById(id);
        List<Role> roles = userService.findRoleList();
        model.addAttribute("editUser", userEditRoleDto);
        model.addAttribute("roles", roles);
        return "admin/editUser";
    }

    @PostMapping("/edit")
    public String edutUserPost(@ModelAttribute("editUser") @Valid UserEditRoleDto userEditRoleDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/editUser";
        }
        userService.update(userEditRoleDto);
        return "redirect:/admin/viewUser";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/admin/view";
    }

    @ModelAttribute("headername")
    public String headerName() {
        return "Użytkownik";
    }

    @ModelAttribute("shops")
    public Collection<ShopDto> shops() {
        return shopService.findAll();
    }

    @ModelAttribute("basicUserData")
    public String[] basicUserData(@AuthenticationPrincipal CurrentUser currentUser) {
        return new String[]{currentUser.getUsername(), currentUser.getUser().getFirstName(), currentUser.getUser().getShop().getShopName()};
    }
    @ModelAttribute ("roles")
    public List<Role> listOfRoles (){
        return userService.findRoleList();
    }
}
