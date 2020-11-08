package pl.sda.bootcamp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bootcamp.model.User;
import pl.sda.bootcamp.service.CourseService;
import pl.sda.bootcamp.service.RoleService;
import pl.sda.bootcamp.service.UserService;


@Controller
@RequestMapping(value = "/user")
@AllArgsConstructor
public class UserController {

    private final CourseService courseService;
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping(value = "/signup")
    public String create(Model model) {
        model.addAttribute("user", User.builder().build());
        model.addAttribute("coursesList", courseService.getCoursesList());
        return "user/signup";
    }

    @PostMapping(value = "/signup")
    public String get(@ModelAttribute() User user) {
        user.setRole(roleService.findByName("user"));
        userService.save(user);
        return "user/signup-confirmed";
    }

    @GetMapping(value = "/add-trainer")
    public String form(Model model){
        model.addAttribute("user", User.builder().build());
        return "user/add-trainer";
    }

    @PostMapping(value = "add-trainer")
    public String post(@ModelAttribute User createdTrainer, Model model){
        System.out.println(createdTrainer.toString());
        createdTrainer.setRole(roleService.findByName("trainer"));
        userService.save(createdTrainer);
        model.addAttribute("createdTrainer", createdTrainer);
        return "user/add-trainer";
    }
}
