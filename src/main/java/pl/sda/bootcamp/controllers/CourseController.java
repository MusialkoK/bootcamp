package pl.sda.bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/course")
public class CourseController {

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
}
