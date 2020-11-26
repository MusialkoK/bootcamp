package pl.sda.bootcamp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
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

    @NotEmpty(message = "{pl.sda.bootcamp.model.User.firstName.NotEmpty}")
    private String firstName;

    @NotEmpty(message = "{pl.sda.bootcamp.model.User.lastName.NotEmpty}")
    private String lastName;

    @NotEmpty(message = "{pl.sda.bootcamp.model.User.email.NotEmpty}")
    @Email(message = "{pl.sda.bootcamp.model.User.email.isMail}")
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

    @NotEmpty(message = "{pl.sda.bootcamp.model.User.password.NotEmpty}")
    private String password;
    @NotEmpty(message = "{pl.sda.bootcamp.model.User.confirmPassword.NotEmpty}")
    private String confirmPassword;

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

