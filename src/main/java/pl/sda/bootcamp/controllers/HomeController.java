package pl.sda.bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @GetMapping
    public String home(){
        return "home";
    }

    @PostMapping(value = "/action", params = "action=courses")
    public String goToCourseList(){
        return "redirect:course/list";
    }

    @PostMapping(value = "/action", params = "action=users")
    public String goToUserList(){
        return "redirect:admin/user/list";
    }

//    @GetMapping
//    public String home() {
//        System.out.println("Hello world!");
//        return "redirect:course/list";
//    }
//
//    @GetMapping("main-page")
//    public String homePage() {
//        System.out.println("Hello world!");
//        return "forward:course/list";
//    }


}
