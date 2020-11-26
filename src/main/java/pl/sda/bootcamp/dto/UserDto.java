package pl.sda.bootcamp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private BigDecimal hourPrice;
}
