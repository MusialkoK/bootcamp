package pl.sda.bootcamp.model.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRest {
    private Long id;
    private String name;
    private String username;
    private String email;
    private AddressRest address;
    private String phone;
    private String website;
    private CompanyRest company;
}
