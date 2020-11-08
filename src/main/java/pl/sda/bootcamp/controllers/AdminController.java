package pl.sda.bootcamp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.bootcamp.service.UserService;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/admin")
public class AdminController {

    private final UserService userService;

    @GetMapping(value = "/user/list")
    public String viewUserList(Model model){
        model.addAttribute("userList", userService.findAll());
        return "admin/user-list";
    }
}
