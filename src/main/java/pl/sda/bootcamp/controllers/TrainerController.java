package pl.sda.bootcamp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bootcamp.model.Trainer;
import pl.sda.bootcamp.service.TrainerService;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/trainer")
public class TrainerController {

    private final TrainerService trainerService;

    @GetMapping(value = "/add")
    public String form(Model model){
        model.addAttribute("trainer", Trainer.builder().build());
        return "trainer/add";
    }

    @PostMapping(value = "/add")
    public String post(@ModelAttribute Trainer createdTrainer, Model model){
        System.out.println(createdTrainer.toString());
        trainerService.save(createdTrainer);
        model.addAttribute("createdTrainer", createdTrainer);
        return "trainer/add";
    }
}
