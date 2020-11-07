package pl.sda.bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bootcamp.model.Course;
import pl.sda.bootcamp.model.SignUpDTO;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static pl.sda.bootcamp.model.CourseMode.*;


@Controller
@RequestMapping(value = "/user")
public class UserController {
    private List<Course> courses = new ArrayList<>();
    private List<String> courseNames = new ArrayList<>();

    @GetMapping(value = "/signup")
    public String create(Model model){
        createCourses();
        courseNames = getCoursesNames();
        model.addAttribute("signup", SignUpDTO.builder().build());
        model.addAttribute("coursesList", courses);
        return "user/signup";
    }
    @PostMapping(value = "/signup")
    public String get(@ModelAttribute() SignUpDTO signup){
        return "user/signup-confirmed";
    }

    private void createCourses(){
        courses.add( new Course().setId(1L).setName("Java from scratch").setCity("Warszawa").setMode(DAY));
        courses.add( new Course().setId(2L).setName("Java from scratch").setCity("Gdańsk").setMode(EVENING));
        courses.add( new Course().setId(3L).setName("Python from scratch").setCity("Gdańsk").setMode(EXTRAMURAL));
        courses.add( new Course().setId(4L).setName("Python from scratch").setCity("Warszawa").setMode(EVENING));
        courses.add( new Course().setId(5L).setName("Python from scratch").setCity("Poznań").setMode(DAY));
        courses.add( new Course().setId(6L).setName("Tester from scratch").setCity("Poznań").setMode(EXTRAMURAL));
    }

    private List<String> getCoursesNames(){
        return courses.stream().map(this::getCourseNameCity).collect(Collectors.toList());
    }

    private String getCourseNameCity(Course c){
        return c.getName() + ", " + c.getCity();
    }
}
