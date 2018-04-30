package tour.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tour.tour.entity.Country;
import tour.tour.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping("/save")
    public Country save(@RequestBody Country country) {
        return countryService.save(country);
    }

    @GetMapping("/getCountry")
    public List<Country> getCountry() {
        return countryService.findAll();
    }

    @GetMapping("/deleteCountry/{id}")
    public ResponseEntity deleteCountry(@PathVariable("id") Long id) {
        countryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
