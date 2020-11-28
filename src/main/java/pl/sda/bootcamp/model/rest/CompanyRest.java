package pl.sda.bootcamp.model.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRest {
    private String name;
    private String catchPhrase;
    private String bs;
}
