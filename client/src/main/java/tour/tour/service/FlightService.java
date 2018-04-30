package tour.tour.service;

import tour.tour.entity.Country;
import tour.tour.entity.Flight;

import java.util.List;

public interface FlightService {
    Flight save(Flight flight);
    Flight change(Flight flight);
    Flight findOne(Long id);
    List<Flight> findAll();
    void delete(Long id);
    void delete(Flight flight);
    List<Flight> findByEndPlace(String endPlace);
}
