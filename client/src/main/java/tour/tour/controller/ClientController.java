package tour.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tour.tour.entity.Client;
import tour.tour.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/saveClient")
    public Client saveClient(@RequestBody Client client) {
        return clientService.save(client);
    }


    @GetMapping("/deleteClient/{id}")
    public ResponseEntity deleteClient(@PathVariable("id") Long id) {
        clientService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/getClient")
    public List<Client> getClient() {
        return clientService.findAll();
    }


}
