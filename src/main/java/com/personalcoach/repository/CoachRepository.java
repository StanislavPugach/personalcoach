package com.personalcoach.repository;

import com.personalcoach.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach,Long> {

    Coach findByExperience(float experience);

    Coach findByLogin(String login);

}
