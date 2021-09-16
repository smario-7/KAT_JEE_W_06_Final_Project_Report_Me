package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dto.ShopDto;
import pl.coderslab.dto.UserAddDto;
import pl.coderslab.service.ShopService;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private static final Logger log = LoggerFactory.getLogger(RegisterController.class);
    private final UserService userService;
    private final ShopService shopService;

    public RegisterController(UserService userService, ShopService shopService) {
        this.userService = userService;
        this.shopService = shopService;
    }

    @GetMapping
    public String register (Model model){
        model.addAttribute("user", new UserAddDto());
        return "register";
    }
    @PostMapping
    public String postRegister (@ModelAttribute("user") @Valid UserAddDto user, BindingResult bindingResult){
        log.info("!!!!! {}" , user);

        if (bindingResult.hasErrors()){
            return "register";
        } else if (!userService.passwordConfirm(user)){
            bindingResult.rejectValue("passwordRepeat", "passwordRepeat", "różne hasła");
            if (userService.userExist(user)){
                bindingResult.rejectValue("email","email","email już istnieje");
                return "register";
            }
            return "register";
        }
        userService.add(user);
        return "login";
    }
    @ModelAttribute("shops")
    public List<ShopDto> shops(){return shopService.findAllNext();}
}
