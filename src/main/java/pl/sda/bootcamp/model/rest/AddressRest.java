package pl.sda.bootcamp.model.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRest {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoRest geo;

}
