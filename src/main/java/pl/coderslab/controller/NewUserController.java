package pl.coderslab.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.service.CurrentUser;

@Controller
@RequestMapping("/newUser")
public class NewUserController {

    @RequestMapping
    public String newUser(){
    return "newUser";
    }

    @ModelAttribute("basicUserData")
    public String[] basicUserData(@AuthenticationPrincipal CurrentUser currentUser) {
        return new String[]{currentUser.getUsername(), currentUser.getUser().getFirstName()};
    }
}
