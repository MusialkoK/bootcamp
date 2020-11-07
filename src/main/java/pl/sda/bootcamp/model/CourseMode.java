package pl.sda.bootcamp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CourseMode {
    DAY("Dzienny"),
    EVENING("Wieczorowy"),
    EXTRAMURAL("Zaoczny");

    private final String description;
}
