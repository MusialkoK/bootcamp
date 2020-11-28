package pl.sda.bootcamp.service.rest;

import org.springframework.stereotype.Service;
import pl.sda.bootcamp.factory.PostFactory;
import pl.sda.bootcamp.model.rest.CommentRest;
import pl.sda.bootcamp.model.rest.Post;
import pl.sda.bootcamp.model.rest.PostRest;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    PostRestService postRestService;
    CommentRestService commentRestService;
    PostFactory postFactory;

    public List<Post> getPosts(){
        List<PostRest> postRestList = postRestService.getAllPosts();
        List<CommentRest> commentRestList = commentRestService.getAllComments();
        return postRestList.stream()
                .map(post->postFactory.create(post,commentRestList))
                .collect(Collectors.toList());
    }

}
