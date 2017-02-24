package com.personalcoach.controller;

import com.personalcoach.model.Registration;
import com.personalcoach.service.RegistrationService;
import com.personalcoach.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String showOne (@RequestParam("id") long id, Model model){
        model.addAttribute("testvar",testService.findOne(id));

        return "404";
    }

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String login() {
        return "loginpage";
    }

}
