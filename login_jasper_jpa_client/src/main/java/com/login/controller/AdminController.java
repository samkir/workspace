package com.login.controller;

import java.io.IOException;
import java.util.HashMap;
import javax.validation.Valid;


import com.login.model.AppUser;
import com.login.service.AppUserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class AdminController {
    @Autowired
    private AppUserServiceImpl service;
   

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("admin", service.findAll());
        AppUser a=service.findAll().get(1);
       
        model.addAttribute("newUser", new AppUser());
        return "tasks";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestParam Long id, AppUser user) {
        service.update(id, user);
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String delete(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("newUser") AppUser user) {
        service.create(user);
        return "redirect:/";
    }

    

}
