package tour.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tour.tour.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    Client findByPassport(String passport);
    void deleteByPassport(String passport);
    void delete(Client client);
}
