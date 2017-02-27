package com.personalcoach.service;

import com.personalcoach.model.Client;
import com.personalcoach.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client findOne(long id) {
        return clientRepository.findOne(id);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Transactional
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public void delete(long id){
        clientRepository.delete(id);
    }
}
