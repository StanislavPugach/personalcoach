package com.personalcoach.service;

import com.personalcoach.model.Coach;
import com.personalcoach.model.enams.UserRole;
import com.personalcoach.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class CoachService {

    @Autowired
    private CoachRepository coachRepository;

    public Coach findOne(long id) {
        return coachRepository.findOne(id);
    }

    public List<Coach> findAll() {
        return coachRepository.findAll();
    }

    @Transactional
    public Coach save(Coach coach) {
        return coachRepository.save(coach);
    }
}
