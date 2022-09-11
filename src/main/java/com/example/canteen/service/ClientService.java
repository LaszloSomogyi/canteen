package com.example.canteen.service;

import com.example.canteen.exceptions.ClientNotFoundException;
import com.example.canteen.model.Client;
import com.example.canteen.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

    public Client findClientById(Long id) {
        return clientRepo.findById(id).orElseThrow(() -> new ClientNotFoundException("Non-Existent client!"));
    }
}
