package pl.sda.bootcamp.factory;

import org.springframework.stereotype.Service;
import pl.sda.bootcamp.model.rest.CommentRest;
import pl.sda.bootcamp.model.rest.Post;
import pl.sda.bootcamp.model.rest.PostRest;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostFactory {
    public Post create(PostRest postRest, List<CommentRest> commentRests){
        return Post.builder()
                .body(postRest.getBody())
                .id(postRest.getId())
                .userId(postRest.getUserId())
                .title(postRest.getTitle())
                .comments(extractComments(postRest.getId(), commentRests))
                .build();
    }

    private List<CommentRest> extractComments(Long id, List<CommentRest> commentRests){
        return commentRests.stream().filter(c->c.getPostId().equals(id)).collect(Collectors.toList());
    }
}
