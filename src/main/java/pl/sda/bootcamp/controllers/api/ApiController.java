package pl.sda.bootcamp.controllers.api;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.bootcamp.dto.CourseDto;
import pl.sda.bootcamp.service.rest.ApiService;
import pl.sda.bootcamp.service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
@AllArgsConstructor
public class ApiController {

    private final ApiService apiService;
    private final UserService userService;


    @ResponseBody
    @GetMapping("/course/all")
    public List<CourseDto> getCourses() {
        return apiService.getAllCourses();
    }

    @ResponseBody
    @GetMapping("/course/{id}")
    public CourseDto getSingleCourse(@PathVariable Long id) {
        return apiService.getCourseById(id);
    }

}
