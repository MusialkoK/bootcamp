package pl.sda.bootcamp.controllers.api;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bootcamp.dto.CourseDto;
import pl.sda.bootcamp.model.rest.PostRest;
import pl.sda.bootcamp.service.rest.ApiService;
import pl.sda.bootcamp.service.rest.PostRestService;
import pl.sda.bootcamp.service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
@AllArgsConstructor
public class ApiController {

    private final ApiService apiService;
    private final UserService userService;
    private final PostRestService postRestService;

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

    @GetMapping("/rest-template/post/create")
    public String getPost(Model model) {
        model.addAttribute("postRest", PostRest.builder().build());
        model.addAttribute("userList", userService.findAll());
        return "/api/post-create";
    }

    @PostMapping("/rest-template/post/create")
    public String sendPost(@ModelAttribute PostRest post, Model model) {
        PostRest response = postRestService.sendPost(post);
        model.addAttribute("postId", response.getId());
        return "/api/success";
    }
}
