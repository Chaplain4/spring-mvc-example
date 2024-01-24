package com.journaldev.spring.controller;

import com.journaldev.spring.model.Phone;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/phone")
public class PhoneController {
    private static List<Phone> phoneList = new ArrayList<>();
    static {
        phoneList.add(new Phone(1, "Nokia 6290", (double) 500));
        phoneList.add(new Phone(2, "Siemens A52", (double) 600));
    }

    @RequestMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/add", method = RequestMethod.POST)
    public String addPhone(@ModelAttribute Phone phone, Model model) {
        boolean isAdded = phoneList.add(phone);
        model.addAttribute("msg", isAdded? "Phone with id " + phone.getId() + " added successfully!" : "not added");
        return "result";
    }

    @RequestMapping(value = "/show_all", method = RequestMethod.GET)
    public String show(Model model) {
        StringBuilder result = new StringBuilder(128);
        phoneList.forEach((phone) -> {
            result.append(phone.toString() + "<br>");
        });
        model.addAttribute("msg", "All phones: <br>" + result.toString());
        return "result";
    }
}
