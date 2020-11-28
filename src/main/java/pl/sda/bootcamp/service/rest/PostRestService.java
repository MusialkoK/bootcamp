package pl.sda.bootcamp.service.rest;

import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.bootcamp.model.rest.PostRest;

import java.util.List;

@Service
@AllArgsConstructor
public class PostRestService {

    public List<PostRest> getAllPosts(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<PostRest>> exchange = restTemplate.exchange(
                "https://jsonplaceholder.typicode.com/posts",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<>() {}
        );

        return exchange.getBody();
    }

    public PostRest sendPost(PostRest postRest){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(postRest, headers);
        ResponseEntity<PostRest> exchange = restTemplate.exchange(
                "https://jsonplaceholder.typicode.com/posts",
                HttpMethod.POST,
                entity,
                PostRest.class
        );
        return exchange.getBody();
    }



}
