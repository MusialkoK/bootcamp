package pl.sda.bootcamp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bootcamp.model.City;
import pl.sda.bootcamp.model.Course;
import pl.sda.bootcamp.model.CourseMode;
import pl.sda.bootcamp.model.User;
import pl.sda.bootcamp.service.CourseService;
import pl.sda.bootcamp.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/course")
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;
    private final UserService userService;

    @GetMapping(value = "/list")
    public String courseList(Model model){
        model.addAttribute("courseList", courseService.getCoursesList());
        return "course/list";
    }
    @GetMapping(value = "/list/{courseId}")
    public String getCourse(@PathVariable String courseId,  Model model){
        model.addAttribute("id", courseId);
        System.out.println("Course id: "+ courseId);
        return "course/list";
    }

    @GetMapping(value = "/add")
    public String addCourse(Model model) {
        model.addAttribute("cityList", City.values());
        model.addAttribute("trainerList", userService.getTrainersList());
        model.addAttribute("course", Course.builder().build());
        model.addAttribute("modes", CourseMode.values());
        return "course/add";
    }

    @PostMapping(value = "/add")
    public String create(@ModelAttribute Course course, Model model) {
        System.out.println(course);
        courseService.saveCourse(course);
        model.addAttribute("createdCourse", course);
        model.addAttribute("cityList", City.values());
        model.addAttribute("trainerList", userService.getTrainersList());
        model.addAttribute("modes", CourseMode.values());
        return "course/add";
    }
}
