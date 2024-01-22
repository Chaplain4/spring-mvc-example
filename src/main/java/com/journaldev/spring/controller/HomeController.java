package com.journaldev.spring.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {


    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        System.out.println("Root Page Requested, Server locale = " + locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "home";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        System.out.println("test");
        return "home";
    }

    @RequestMapping(value = "/old", method = RequestMethod.GET)
    public void testOld(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("Hello from Spring Controller");
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String test2(Model model) {
        model.addAttribute("first", Math.random());
        model.addAttribute("second", Math.random());
        return "fs";
    }

    @RequestMapping(value = "/test3", method = RequestMethod.GET)
    public ModelAndView test3(ModelAndView model) {
        model.addObject("first", Math.random());
        model.addObject("second", Math.random());
        model.setViewName("fs");
        return model;
    }

    @RequestMapping(value = "/test4", method = RequestMethod.GET)
    public ModelAndView test4() {
        ModelAndView model = new ModelAndView("fs");
        model.addObject("first", Math.random());
        model.addObject("second", Math.random());
        model.setViewName("fs");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Validated User user, Model model) {
        if (user.getLogin().equals("John") && user.getPwd().equals("123")) {
            return "welcome";
        } else return "not_welcome";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String user(@Validated User user, Model model) {
        System.out.println("User Page Requested");
        model.addAttribute("name", user.getName());
        return "user";
    }
}
