package tour.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tour.tour.entity.Flight;
import tour.tour.service.FlightService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/saveFlight")
    public Flight saveFlight(@RequestBody Flight flight) {
        return flightService.save(flight);
    }


    @GetMapping("/getFlight")
    public List<Flight> getFlight() {
        return flightService.findAll();
    }


    @GetMapping("/deleteFlight/{id}")
    public ResponseEntity deleteFlight(@PathVariable("id") Long id) {
        flightService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/getFlightByCountry/{country}")
    public List<Flight> getFlightByCountry(@PathVariable("country") String country) {
        return this.flightService.findByEndPlace(country);
    }
}
