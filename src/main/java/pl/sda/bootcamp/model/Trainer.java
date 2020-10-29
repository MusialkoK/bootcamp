package pl.sda.bootcamp.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Trainer {
    String name;
    String lastName;
    double hourPrice;

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hourPrice=" + hourPrice +
                '}';
    }
}
