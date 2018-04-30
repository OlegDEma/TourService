package tour.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tour.tour.entity.Country;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
    Country findByName(String name);
    void deleteByName(String name);
    @Query("SELECT c from Country c order by id")
    List<Country> findAllById();
}
