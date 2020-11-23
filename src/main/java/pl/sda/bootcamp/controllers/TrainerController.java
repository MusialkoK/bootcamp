package pl.sda.bootcamp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.bootcamp.model.User;
import pl.sda.bootcamp.service.RoleService;
import pl.sda.bootcamp.service.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/trainer")
public class TrainerController {

    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("")
    public String dashboard() {
        return "trainer/dashboard";
    }

    @GetMapping(value = "/add-trainer")
    public String form(Model model){
        model.addAttribute("trainer", User.builder().build());
        return "trainer/add-trainer";
    }

    @PostMapping(value = "/add-trainer")
    public String post(@Valid @ModelAttribute User createdTrainer, BindingResult bindingResult, Model model){
        model.addAttribute("createdTrainer", createdTrainer);
        if(bindingResult.hasErrors()){
            List<String> errorMessages = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
            model.addAttribute("errorMessages", errorMessages);
            return "trainer/add-trainer";
        }else{
            createdTrainer.setRole(roleService.findByName("trainer"));
            userService.save(createdTrainer);
            return "trainer/add-trainer-confirmed";
        }
    }

    @PostMapping(value = "/courses")
    public String viewCourses(Authentication authentication){
        User trainer = (User) authentication.getPrincipal();
        System.out.println(trainer.getId());
        return "";
    }

    @GetMapping(value = "/dashboard")
    public String dashboard(Model model, Principal principal){
        User user = userService.getUserByMail(principal.getName());
        model.addAttribute("user",user);
        return "trainer/dashboard";
    }

}
