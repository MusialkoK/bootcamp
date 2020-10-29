package pl.sda.bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bootcamp.model.Trainer;

@Controller
@RequestMapping(value = "/trainer/add")
public class AddTrainerController {

    @GetMapping
    public String form(Model model){
        model.addAttribute("trainer", Trainer.builder().build());
        return "trainer/add";
    }

    @PostMapping
    public String post(@ModelAttribute Trainer createdTrainer, Model model){
        System.out.println(createdTrainer.toString());
        model.addAttribute("createdTrainer", createdTrainer);
        return "trainer/add";
    }
}
