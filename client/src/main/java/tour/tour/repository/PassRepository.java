package tour.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tour.tour.entity.Pass;

@Repository
public interface PassRepository extends JpaRepository<Pass,Long> {
}
