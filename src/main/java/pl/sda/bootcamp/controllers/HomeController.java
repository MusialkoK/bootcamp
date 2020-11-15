package pl.sda.bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping
    public String home(){
        return "home";
    }

    @PostMapping(value = "/panel", params = "panel=admin")
    public String goToUserList(){
        return "redirect:/admin/user/list";
    }

    @PostMapping(value = "/panel", params = "panel=client")
    public String goToClientDashboard(){
        return "redirect:/client-dashboard";
    }

    @PostMapping(value = "/panel", params = "panel=trainer")
    public String goToTrainerDashboard(){
        return "redirect:/trainer-dashboard/add-trainer";
    }

    @PostMapping(value = "/action", params = "action=courses")
    public String viewCourseList(){
        return "redirect:/course/list";
    }

    @PostMapping(value = "/action", params = "action=add-course")
    public String addCourse(){
        return "redirect:/course/add";
    }

//    @GetMapping
//    public String home() {
//        System.out.println("Hello world!");
//        return "redirect:course/list";
//    }
////
//    @GetMapping("main-page")
//    public String homePage() {
//        System.out.println("Hello world!");
//        return "forward:course/list";
//    }


}
