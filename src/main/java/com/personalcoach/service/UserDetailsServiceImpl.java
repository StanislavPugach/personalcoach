package com.personalcoach.service;

import com.personalcoach.model.Client;
import com.personalcoach.model.Coach;
import com.personalcoach.model.enams.UserRole;
import com.personalcoach.repository.ClientRepository;
import com.personalcoach.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService{

    private static final String ADMIN_LOGIN = "a";
    private static final String ADMIN_PASSWORD = "a";

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CoachRepository coachRepository;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        List<GrantedAuthority> roles = new ArrayList<>();

        if (login.equals(ADMIN_LOGIN)) {
            roles.add(new SimpleGrantedAuthority(UserRole.ROLE_ADMIN.name()));
            return new User(ADMIN_LOGIN,ADMIN_PASSWORD,roles);
        }
        Coach coach = coachRepository.findByLogin(login);
        if (coach != null) {
            roles.add(new SimpleGrantedAuthority(UserRole.ROLE_COACH.name()));
            return new User(coach.getLogin(), coach.getPassword(), roles);
        }
        Client client = clientRepository.findByLogin(login);
        if (coach != null) {
            roles.add(new SimpleGrantedAuthority(UserRole.ROLE_CLIENT.name()));
            return new User(client.getLogin(), client.getPassword(), roles);
        }
        throw new UsernameNotFoundException("User " + login + " not found.");
    }
}
