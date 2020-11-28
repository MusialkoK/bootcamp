package pl.sda.bootcamp.model.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRest {
    private Long id;
    private Long userId;
    private String title;
    private String body;
}
