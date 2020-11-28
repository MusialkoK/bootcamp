package pl.sda.bootcamp.model.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Long id;
    private Long userId;
    private String title;
    private String body;
    private List<CommentRest> comments;
}
