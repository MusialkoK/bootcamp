package pl.sda.bootcamp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.bootcamp.model.Message;

@Controller
public class RestExampleController {

    @GetMapping("/rest/hi")
    public ResponseEntity<String> sayHi() {
        return ResponseEntity.ok().body("Hi");
    }

    @GetMapping("/rest/hello")
    public ResponseEntity<Message> sayHello() {
        return ResponseEntity.ok().body(new Message("Hello"));
    }

    @GetMapping("/rest/message")
    @ResponseBody
    public Message getMessage(){
        return new Message("Hello World");
    }

    @ResponseBody
    @PostMapping("/rest/message")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMessage(@RequestBody final Message message){
        System.out.println(message.getText());
    }
}

