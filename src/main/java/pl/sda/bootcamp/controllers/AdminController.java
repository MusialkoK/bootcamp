package pl.sda.bootcamp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.bootcamp.model.Course;
import pl.sda.bootcamp.model.User;
import pl.sda.bootcamp.security.AppUserDetailsService;
import pl.sda.bootcamp.service.CourseService;
import pl.sda.bootcamp.service.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/admin")
public class AdminController {

    private final UserService userService;
    private final CourseService courseService;
    private final AppUserDetailsService userDetailsService;

    @GetMapping(value = "/user/list")
    public String viewUserList(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "admin/user-list";
    }

    @GetMapping(value = "/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin/user/list";
    }

    @GetMapping(value = "/user/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        String returnPath;
        User user = userService.getUserById(id);
        model.addAttribute("userToEdit", user);
        List<Course> availableCourses = courseService.getCoursesList();
        switch ((int) user.getRole().getId()) {
            case 3:
                user.getTrainerCourses().forEach(availableCourses::remove);
                returnPath = "admin/trainer-edit";
                break;
            default:
                user.getCourseList().forEach(availableCourses::remove);
                returnPath = "admin/user-edit";
                break;
        }
        model.addAttribute("availableCourses", availableCourses);
        return returnPath;
    }

    @PostMapping(value = "/user/edit")
    public String saveEditedUser(@Valid @ModelAttribute User editedUser, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<String> errorMsg = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
            model.addAttribute("errorMsg", errorMsg);
            model.addAttribute("userToEdit", editedUser);
            List<Course> availableCourses = courseService.getCoursesList();
            editedUser.getTrainerCourses().forEach(availableCourses::remove);
            model.addAttribute("availableCourses", availableCourses);
            return "admin/user-edit";
        } else {
            userService.save(editedUser);
            return "redirect:/admin/user/list";
        }

    }

    @PostMapping(value = "/user/edit/trainer")
    public String saveEditedTrainer(@ModelAttribute User editedUser) {
        userService.updateTrainer(editedUser);
        return "redirect:/admin/user/list";
    }

    @GetMapping(value = "/dashboard")
    public String dashboard(Model model, Principal principal) {
        User user = userService.getUserByMail(principal.getName());
        model.addAttribute("user", user);
        return "admin/dashboard";
    }
}
