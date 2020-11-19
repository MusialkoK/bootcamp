package pl.sda.bootcamp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.bootcamp.model.City;
import pl.sda.bootcamp.model.CourseMode;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDto {
    private Long id;
    private String name;
    private City city;
    private LocalDate startDate;
    private LocalDate finishDate;
    private double price;
    private UserDto trainer;
    private CourseMode mode;
    private List<UserDto> courseUsers;

}
