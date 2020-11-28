package pl.sda.bootcamp.model.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentRest {
    private Long postId;
    private Long id;
    private String name;
    private String email;
    private String body;
}
