package pl.sda.bootcamp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


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

    @ManyToMany(mappedBy = "courseList")
    private List<User> users;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private User trainer;

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

    public String getTrainerName(){
        return trainer!=null ? trainer.nameToString() : "NO TRAINER ASSIGN";
    }


}
