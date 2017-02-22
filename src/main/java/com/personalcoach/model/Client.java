package com.personalcoach.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends Person {

    @ManyToOne
    @JoinColumn
    private Coach coach;
    private String profilePhoto;
    @ElementCollection
    private List<String> portfolioPhotos;
    @ManyToMany(mappedBy = "clients")
    private List<Reward> rewards = new ArrayList<>();

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
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

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }
}
