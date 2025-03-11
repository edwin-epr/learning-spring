package org.edwinepr.implrestservice.controllers;

import org.edwinepr.implrestservice.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping(path = "/france")
    public Country france() {
        Country country = Country.of("France", 67);
        return country;
    }

    @GetMapping(path = "/all")
    public List<Country> countryList() {
        Country country1 = Country.of("France", 67);
        Country country2 = Country.of("Spain", 47);

        return List.of(country1, country2);
    }
}
