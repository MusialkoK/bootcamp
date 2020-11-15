package pl.sda.bootcamp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;


@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Enter name")
    private String firstName;

    @NotEmpty(message = "{pl.sda.bootcamp.model.User.lastName.NotEmpty}")
    private String lastName;

    @NotEmpty
    private String email;
    private String phone;
    private BigDecimal hourPrice;
    @ManyToMany
    private List<Course> courseList;

    @OneToMany(mappedBy = "trainer")
    private List<Course> trainerCourses;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    private String password;

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String nameToString() {
        return (firstName != null && lastName != null) ? firstName + " " + lastName : "";
    }

}

