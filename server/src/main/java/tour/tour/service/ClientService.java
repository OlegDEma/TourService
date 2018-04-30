package tour.tour.service;

import tour.tour.entity.Client;

import java.util.List;

public interface ClientService {
    Client save(Client client);
    Client change(Client client);
    Client findOne(Long id);
    Client findByPassport(String passport);
    List<Client> findAll();
    void delete(Long id);
    void deleteByPassport(String passport);
    void delete(Client client);
}
