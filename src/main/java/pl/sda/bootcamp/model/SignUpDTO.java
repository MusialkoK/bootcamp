package pl.sda.bootcamp.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class SignUpDTO {
    User user = new User();
    Course course = new Course();
}
