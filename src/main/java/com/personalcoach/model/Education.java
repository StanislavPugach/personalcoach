package com.personalcoach.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name = "Educations")
public class Education extends AbstractPersistable<Long> {

    private String institution;
    @Column(columnDefinition = "TEXT")
    private String description;
    @ManyToOne
    @JoinColumn
    private Coach coach;

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    @Override
    public Long getId() {
        return super.getId();
    }
}
