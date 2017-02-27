package com.personalcoach.controller;

import com.personalcoach.model.Client;
import com.personalcoach.model.Coach;
import com.personalcoach.model.Registration;
import com.personalcoach.model.enams.UserRole;
import com.personalcoach.service.ClientService;
import com.personalcoach.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    CoachService coachService;

    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String signup(Model model) {
        Registration registration = new Registration();
        model.addAttribute("registration", registration);

        return "registration";
    }

    @RequestMapping(value = "/registration/save" , method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("registration") @Valid Registration registration,
                                      Errors errors) {
        if (errors.hasErrors()){
            System.out.println(errors.getFieldError());
            return "404";
        }
        if (registration.getRole().equals(UserRole.ROLE_COACH)){
            Coach coach = new Coach();

            coach.setFirstName(registration.getFirstname());
            coach.setLastName(registration.getLastname());
            coach.setEmail(registration.getEmail());
            coach.setLogin(registration.getLogin());
            coach.setPassword(registration.getPassword());

            coachService.save(coach);
            return "home";
        }
        else if (registration.getRole().equals(UserRole.ROLE_CLIENT)){
            Client client = new Client();

            client.setFirstName(registration.getFirstname());
            client.setLastName(registration.getLastname());
            client.setEmail(registration.getEmail());
            client.setLogin(registration.getLogin());
            client.setPassword(registration.getPassword());

            clientService.save(client);
            return "home";
        }
        return "404";
    }
}
