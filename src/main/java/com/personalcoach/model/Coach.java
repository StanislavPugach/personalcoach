package com.personalcoach.model;

import com.personalcoach.model.enams.UserRole;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "coaches")
public class Coach extends Person{

    @Enumerated(EnumType.STRING)
    private final UserRole role = UserRole.ROLE_COACH;
    @ElementCollection
    private List<Integer> rating;
    private Float experience;
    @OneToMany(mappedBy = "coach")
    private List<Education> education;
    @OneToMany(mappedBy = "coach")
    private List<Client> clients;
    private String profilePhoto;
    @ElementCollection
    private List<String> portfolioPhotos;
    @OneToMany(mappedBy = "coach")
    private List<Reward> rewards;

    //TODO add test results


    public List<Integer> getRating() {
        return rating;
    }

    public void setRating(List<Integer> rating) {
        this.rating = rating;
    }

    public Float getExperience() {
        return experience;
    }

    public void setExperience(Float experience) {
        this.experience = experience;
    }

    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public List<String> getPortfolioPhotos() {
        return portfolioPhotos;
    }

    public void setPortfolioPhotos(List<String> portfolioPhotos) {
        this.portfolioPhotos = portfolioPhotos;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

}
