package com.journaldev.spring.controller;


import com.journaldev.spring.dao.UserDAO;
import com.journaldev.spring.model.User;
import com.journaldev.spring.util.EmailUtils;
import com.journaldev.spring.util.EncryptDecryptUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class UserController {
    private static final Logger logger = LogManager.getLogger(EmpController.class);

    @Autowired
    private UserDAO dao; //will inject dao from XML file

    @Autowired
    private EmailUtils emailUtils;

    @Autowired
    private EncryptDecryptUtils encryptDecryptUtils;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(Model model) {
        User user = new User();
        model.addAttribute("command", user);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User user, Model model) {
        //1.First check by login
        User u = dao.getUserByLogin(user.getLogin());
        if (u != null) {
            if (user.getPassword().equals(EncryptDecryptUtils.decrypt(u.getPassword()))) {
                model.addAttribute("firstName", u.getFirstName());
                return "welcome";
            } else {
                model.addAttribute("error_msg", "Incorrect pwd!");
                return "not_welcome";
            }
        } else {
            model.addAttribute("error_msg", "Login not found!");
            return "not_welcome";
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String user(@Validated User user, Model model) {
        System.out.println("User Page Requested");
        model.addAttribute("name", user.getFirstName());
        return "user";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegister(Model model) {
        User user = new User();
        model.addAttribute("command", user);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user, Model model) {
        if (!(dao.getUserByLogin(user.getLogin()) == null && dao.getUserByEmail(user.getEmail()) == null)) {
            model.addAttribute("error_msg", "Login or email exists!");
            return "not_welcome";
        } else {
            user.setPassword(EncryptDecryptUtils.encrypt(user.getPassword()));
            dao.save(user);
            model.addAttribute("firstName", user.getFirstName());
            return "welcome";
        }
    }
}


