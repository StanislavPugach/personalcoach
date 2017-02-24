package com.personalcoach.model;

import com.personalcoach.model.enams.UserRole;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "registration")
public class Registration extends AbstractPersistable<Long> {
    @NotNull
    @Size(min = 2, max = 50)
    private String firstname;
    @NotNull
    @Size(min = 2, max = 50)
    private String lastname;
    @NotNull
    @Size(min = 2, max = 30)
    private String email;
    @NotNull
    @Size(min = 2, max = 50)
    private String login;
    @NotNull
    @Size(min = 6, max = 50)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z[а-я]])(?=.*[A-Z[А-Я]])(?=\\S+$).{8,}$")
    private String password;
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    protected void setId(Long id) {
        super.setId(id);
    }
}
