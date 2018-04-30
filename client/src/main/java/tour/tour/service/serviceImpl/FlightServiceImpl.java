package tour.tour.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tour.tour.entity.Flight;
import tour.tour.repository.FlightRepository;
import tour.tour.service.FlightService;

import java.util.List;

@Service("flightService")
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight change(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight findOne(Long id) {
        return flightRepository.findOne(id);
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        flightRepository.delete(id);
    }

    @Override
    public void delete(Flight flight) {
        flightRepository.delete(flight);
    }

    @Override
    public List<Flight> findByEndPlace(String endPlace) {
        return this.flightRepository.findByEndPlace(endPlace);
    }
}
