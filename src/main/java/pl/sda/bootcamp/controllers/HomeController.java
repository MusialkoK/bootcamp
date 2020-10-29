package pl.sda.bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @GetMapping
    public String home() {
        System.out.println("Hello world!");
        return "redirect:course/list";
    }

    @GetMapping("main-page")
    public String homePage() {
        System.out.println("Hello world!");
        return "forward:course/list";
    }


}
