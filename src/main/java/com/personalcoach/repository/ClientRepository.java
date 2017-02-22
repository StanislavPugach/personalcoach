package com.personalcoach.repository;

import com.personalcoach.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {

    Client findByLogin(String login);
}
