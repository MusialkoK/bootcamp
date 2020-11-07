package pl.sda.bootcamp.model;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Builder
@NoArgsConstructor
public class Course {
    private Long id;
    private String name;
    private String city;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate finishDate;
    private double price;
    private String trainer;
    private CourseMode mode;

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", startDate='" + startDate + '\'' +
                ", finishDate='" + finishDate + '\'' +
                ", price=" + price +
                ", trainer='" + trainer + '\'' +
                ", courseMode=" + mode +
                '}';
    }
}
