package pl.sda.bootcamp.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class SignUpDTO {
    Student student = new Student();
    Course course = new Course();
}
