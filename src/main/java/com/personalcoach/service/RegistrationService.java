package com.personalcoach.service;

import com.personalcoach.model.Registration;
import com.personalcoach.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RegistrationService {

    @Autowired
    RegistrationRepository registrationRepository;

    @Transactional
    public Registration save(Registration registration) {
        return registrationRepository.save(registration);
    }

    public List<Registration> findAll() {
        return registrationRepository.findAll();
    }

    public Registration findOne(long id) {
        return registrationRepository.findOne(id);
    }

    @Transactional
    public void delete(long registrationId) {
        registrationRepository.delete(registrationId);
    }
}
