package pl.sda.bootcamp.controllers.api;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.sda.bootcamp.dto.CourseDto;
import pl.sda.bootcamp.service.ApiService;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
@AllArgsConstructor
public class ApiController {

    private final ApiService apiService;

    @ResponseBody
    @GetMapping("/course/all")
    public List<CourseDto> getCourses(){
        return apiService.getAllCourses();
    }

    @ResponseBody
    @GetMapping("/course/{id}")
    public CourseDto getSingleCourse(@PathVariable Long id){
        return apiService.getCourseById(id);
    }

}
