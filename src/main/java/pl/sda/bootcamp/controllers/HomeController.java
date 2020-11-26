package pl.sda.bootcamp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.bootcamp.model.User;
import pl.sda.bootcamp.service.UserService;

import java.security.Principal;
import java.util.Collection;

@Controller
@RequestMapping(value = "/")
@AllArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping
    public String home(Model model, Authentication authentication, Principal principal) {
        User user = new User();
        if (principal != null) {
            user = userService.getUserByMail(principal.getName());
        } else {
            user.setFirstName("Stranger");
        }
        model.addAttribute("user", user);

        if(authentication==null){
            return "home";
        }else{
            return redirect(authentication.getAuthorities());
        }
    }

    private String redirect(Collection<? extends GrantedAuthority> grantedAuthorities) {
        String authority = grantedAuthorities.stream().map(GrantedAuthority::getAuthority).findFirst().get();
        switch (authority) {
            case "ROLE_ADMIN":
                return "redirect:/admin/dashboard";
            case "ROLE_TRAINER":
                return "redirect:/trainer/dashboard";
            case "ROLE_USER":
                return "redirect:/user-dashboard";
            default:
                return "home";
        }
    }
}
