package pl.sda.bootcamp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.bootcamp.model.User;
import pl.sda.bootcamp.service.CourseService;
import pl.sda.bootcamp.service.RoleService;
import pl.sda.bootcamp.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping(value = "/user")
@AllArgsConstructor
public class UserController {

    private final CourseService courseService;
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping(value = "/signup")
    public String create(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("coursesList", courseService.getCoursesList());
        return "user/signup";
    }

    @PostMapping(value = "/signup")
    public String get(@ModelAttribute() User user) {
        user.setRole(roleService.findByName("user"));
        userService.save(user);
        return "user/signup-confirmed";
    }
}
