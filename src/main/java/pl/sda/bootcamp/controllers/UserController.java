package pl.sda.bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bootcamp.model.Course;
import pl.sda.bootcamp.model.CourseMode;
import pl.sda.bootcamp.model.SignUpDTO;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        model.addAttribute("coursesNames", courseNames);
        model.addAttribute("coursesModes", CourseMode.values());
        return "user/signup";
    }
    @PostMapping(value = "/signup")
    public String get(@ModelAttribute() SignUpDTO signup){
        System.out.println(signup.getCourse());
        return "user/list";
    }

    private void createCourses(){
        courses.add( new Course().setName("Java from scratch").setCity("Warszawa"));
        courses.add( new Course().setName("Java from scratch").setCity("Gdańsk"));
        courses.add( new Course().setName("Python from scratch").setCity("Gdańsk"));
        courses.add( new Course().setName("Python from scratch").setCity("Warszawa"));
        courses.add( new Course().setName("Python from scratch").setCity("Poznań"));
        courses.add( new Course().setName("Tester from scratch").setCity("Poznań"));
    }

    private List<String> getCoursesNames(){
        return courses.stream().map(this::getCourseNameCity).collect(Collectors.toList());
    }

    private String getCourseNameCity(Course c){
        return c.getName() + ", " + c.getCity();
    }
}