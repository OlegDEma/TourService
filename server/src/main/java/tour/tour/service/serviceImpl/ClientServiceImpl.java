package tour.tour.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tour.tour.entity.Client;
import tour.tour.repository.ClientRepository;
import tour.tour.service.ClientService;

import java.util.List;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client change(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findOne(Long id) {
        return clientRepository.findOne(id);
    }

    @Override
    public Client findByPassport(String passport) {
        return clientRepository.findByPassport(passport);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        clientRepository.delete(id);
    }

    @Override
    public void deleteByPassport(String passport) {
        clientRepository.deleteByPassport(passport);
    }

    @Override
    public void delete(Client client) {
        clientRepository.delete(client);
    }
}
