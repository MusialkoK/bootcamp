package pl.sda.bootcamp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String get(@Valid @ModelAttribute() User createdUser, BindingResult bindingResult, Model model) {
        boolean passwordMatch = createdUser.getPassword().equals(createdUser.getConfirmPassword());
        if(bindingResult.hasErrors() || !passwordMatch){
            model.addAttribute("user", createdUser);
            model.addAttribute("passwordMatch", passwordMatch);
            List<String> errorMessages = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
            model.addAttribute("errorMessages", errorMessages);
            model.addAttribute("coursesList", courseService.getCoursesList());
            return "user/signup";
        }else{
            createdUser.setRole(roleService.findByName("ROLE_USER"));
            userService.save(createdUser);
            return "redirect:admin/user/list";
        }

    }

    @GetMapping(value = "/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }
}

