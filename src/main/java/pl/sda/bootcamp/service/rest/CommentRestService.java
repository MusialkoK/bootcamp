package pl.sda.bootcamp.service.rest;

import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.bootcamp.model.rest.CommentRest;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentRestService {

    public List<CommentRest> getAllComments(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<CommentRest>> exchange = restTemplate.exchange(
                "https://jsonplaceholder.typicode.com/comments",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<>(){}
        );
        return exchange.getBody();
    }
}
