package tour.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tour.tour.entity.Resort;

@Repository
public interface ResortRepository extends JpaRepository<Resort,Long> {
    Resort findByName(String name);
    void deleteByName(String name);
}
