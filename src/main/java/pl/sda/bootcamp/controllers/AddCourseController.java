package pl.sda.bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bootcamp.model.Course;
import pl.sda.bootcamp.model.CourseMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/courses/add")
public class AddCourseController {

    private List<String> cityList = Arrays.asList("Warszawa", "Szczecin", "Gdańsk");
    private List<String> trainerList = Arrays.asList("Wojciech Potocki", "Adam Abacki", "Bartosz Babacki", "Cyryl Cabacki");

    @GetMapping()
    public String addCourse(Model model) {
        model.addAttribute("cityList", cityList);
        model.addAttribute("trainerList", trainerList);
        model.addAttribute("course", Course.builder().build());
        model.addAttribute("modes", CourseMode.values());
        return "/course/add";
    }

    @PostMapping()
    public String create(@ModelAttribute Course course, Model model) {
        System.out.println(course);
        model.addAttribute("createdCourse", course);
        model.addAttribute("cityList", cityList);model.addAttribute("trainerList", trainerList);

        return "/course/add";
    }


}
