package tour.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tour.tour.entity.Flight;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    
    List<Flight> findByEndPlace(String endPlace);
}
