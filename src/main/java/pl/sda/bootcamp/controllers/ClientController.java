package pl.sda.bootcamp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/client-dashboard")
public class ClientController {

    @GetMapping("")
    public String dashboard() {
        return "client/dashboard";
    }
}
