package pl.sda.bootcamp.model;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@AllArgsConstructor
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@Entity

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private City city;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate finishDate;
    private double price;
    private String trainer;
    @Enumerated(EnumType.STRING)
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
