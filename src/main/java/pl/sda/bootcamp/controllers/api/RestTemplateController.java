package pl.sda.bootcamp.controllers.api;

import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.sda.bootcamp.model.rest.Post;
import pl.sda.bootcamp.model.rest.UserRest;
import pl.sda.bootcamp.service.rest.PostService;

import java.util.List;

@RestController
@AllArgsConstructor
public class RestTemplateController {
    PostService postService;

    @GetMapping("/rest-template/get")
    public List<UserRest> getUsers() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<UserRest>> exchange = restTemplate.exchange(
                "http://jsonplaceholder.typicode.com/users",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<>() {
                }
        );

        return exchange.getBody();
    }

    @GetMapping("/api/rest-template/post/all")
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/rest-template/get/{id}")
    public UserRest getUser(@PathVariable Long id) {
        String url = "http://jsonplaceholder.typicode.com/users/" + id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserRest> exchange = restTemplate.exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<>() {
                }
        );

        return exchange.getBody();
    }

}
