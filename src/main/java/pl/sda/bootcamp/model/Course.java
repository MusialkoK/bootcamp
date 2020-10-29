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

    String name;
    String city;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate finishDate;
    double price;
    String trainer;
    CourseMode courseMode = CourseMode.DAY;

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", startDate='" + startDate + '\'' +
                ", finishDate='" + finishDate + '\'' +
                ", price=" + price +
                ", trainer='" + trainer + '\'' +
                ", courseMode=" + courseMode +
                '}';
    }
}
