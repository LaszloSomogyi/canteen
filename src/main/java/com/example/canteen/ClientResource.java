package com.example.canteen;

import com.example.canteen.model.Client;
import com.example.canteen.model.Product;
import com.example.canteen.service.ClientService;
import com.example.canteen.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientResource {
    private final ClientService clientService;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/find/{client_id}")
    public ResponseEntity<Client> getClientById (@PathVariable("client_id") Long clientId) {
        Client client = clientService.findClientById(clientId);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
}
