package tour.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tour.tour.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {

    Hotel findByName(String name);
    void deleteByName(String name);
}
