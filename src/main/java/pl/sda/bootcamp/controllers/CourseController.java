package pl.sda.bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bootcamp.model.Course;
import pl.sda.bootcamp.model.CourseMode;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/course")
public class CourseController {

    private List<String> cityList = Arrays.asList("Warszawa", "Szczecin", "Gdańsk");
    private List<String> trainerList = Arrays.asList("Wojciech Potocki", "Adam Abacki", "Bartosz Babacki", "Cyryl Cabacki");

    @GetMapping("/list")
    public String courseList(@RequestParam(name = "courseId", required = false) String id){
        System.out.println("Course id: "+ id);
        return "course/list";
    }
    @GetMapping("/list/{courseId}")
    public String courseList2(@PathVariable String courseId,  Model model){
        model.addAttribute("id", courseId);
        System.out.println("Course id: "+ courseId);
        return "course/list";
    }

    @GetMapping()
    public String addCourse(Model model) {
        model.addAttribute("cityList", cityList);
        model.addAttribute("trainerList", trainerList);
        model.addAttribute("course", Course.builder().build());
        model.addAttribute("modes", CourseMode.values());
        return "course/add";
    }

    @PostMapping()
    public String create(@ModelAttribute Course course, Model model) {
        System.out.println(course);
        model.addAttribute("createdCourse", course);
        model.addAttribute("cityList", cityList);model.addAttribute("trainerList", trainerList);

        return "course/add";
    }
}
