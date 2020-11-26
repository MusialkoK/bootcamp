package pl.sda.bootcamp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bootcamp.model.City;
import pl.sda.bootcamp.model.Course;
import pl.sda.bootcamp.model.CourseMode;
import pl.sda.bootcamp.service.CourseService;
import pl.sda.bootcamp.service.UserService;


@Controller
@RequestMapping(value = "/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    private final UserService userService;

    private Long currentlyEditedCourse;

    @GetMapping(value = "/list")
    public String courseList(Model model) {
        model.addAttribute("courseList", courseService.getCoursesList());
        return "course/list";
    }

    @GetMapping(value = "/list/{courseId}")
    public String getCourse(@PathVariable String courseId, Model model) {
        model.addAttribute("id", courseId);
        System.out.println("Course id: " + courseId);
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
        courseService.saveCourse(course);
        model.addAttribute("createdCourse", course);
        model.addAttribute("cityList", City.values());
        model.addAttribute("trainerList", userService.getTrainersList());
        model.addAttribute("modes", CourseMode.values());
        model.addAttribute("courseList", courseService.getCoursesList());
        return "course/list";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteCourse(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id);
        courseService.deleteCourse(id);
        model.addAttribute("courseList", courseService.getCoursesList());
        return "redirect:/course/list";
    }


    @GetMapping(value = "/edit/{id}")
    public String editCourse(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id);
        currentlyEditedCourse = id;
        model.addAttribute("course", course);
        model.addAttribute("cityList", City.values());
        model.addAttribute("trainerList", userService.getTrainersList());
        model.addAttribute("modes", CourseMode.values());
        return "course/edit";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute Course course) {
        course.setId(currentlyEditedCourse);
        currentlyEditedCourse = null;
        courseService.saveCourse(course);
        return "redirect:/course/list";
    }
}
