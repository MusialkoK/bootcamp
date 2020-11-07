package pl.sda.bootcamp.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Trainer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastName;
    private double hourPrice;
    @OneToMany
    private List<Course> courseList;

    @Override
    public String toString() {
        return name + " " + lastName;
    }
}
