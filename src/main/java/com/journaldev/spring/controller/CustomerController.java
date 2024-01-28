package com.journaldev.spring.controller;

import com.journaldev.spring.model.Customer;
import com.journaldev.spring.model.Phone;
import com.journaldev.spring.service.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {
    private static CustomerServiceImpl csi = new CustomerServiceImpl();

    @RequestMapping("/customer")
    public ModelAndView home() {
        List<Customer> listCustomer = csi.listAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listCustomer", listCustomer);
        return mav;
    }

    @RequestMapping("/new")
    public String newCustomerForm(Map<String, Object> model) {
        Customer customer = new Customer();
        model.put("customer", customer);
        return "new_customer";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        csi.save(customer);
        return "redirect:/customer";
    }

//    @RequestMapping("/edit")
//    public String editCustomerForm(@RequestParam long id, Map<String, Object> model) {
//        Customer customer = csi.get(id);
//
//        model.put("customer", customer);
//        csi.delete(customer.getId());
//        return "redirect:/customer";
//    }

    @RequestMapping("/edit")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_customer");
        Customer customer = csi.get(id);
        mav.addObject("customer", customer);
        return mav;
    }

    @RequestMapping("/delete")
    public String deleteCustomerForm(@RequestParam long id) {
        csi.delete(id);
        return "redirect:/customer";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Customer> result = csi.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);
        return mav;
    }
}
