package com.journaldev.spring.controller;

import com.journaldev.spring.dao.CustomerDAO;
import com.journaldev.spring.dao.EmpDao;
import com.journaldev.spring.model.Customer;
import com.journaldev.spring.model.Emp;
import com.journaldev.spring.model.Phone;
import com.journaldev.spring.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {
    private static CustomerServiceImpl csi = new CustomerServiceImpl();
    @Autowired
    CustomerDAO cdao;

    @RequestMapping("/customer")
    public String home(Model m) {
        List<Customer> listCustomer = cdao.getCustomers();
        ModelAndView mav = new ModelAndView("index");
        m.addAttribute("listCustomer", listCustomer);
        return "index";
    }

    @RequestMapping("/new")
    public String newCustomerForm(Map<String, Object> model) {
        Customer customer = new Customer();
        model.put("customer", customer);
        return "new_customer";
    }

    @RequestMapping(value = "/saveC", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        cdao.save(customer);
        return "redirect:/customer";
    }

    @RequestMapping(value="/editC",method = RequestMethod.POST)
    public String editC(@ModelAttribute("Customer") Customer emp, RedirectAttributes redirectAttributes){
        int res = cdao.update(emp);
        redirectAttributes.addFlashAttribute("msg", res > 0 ? "Updated" : "Error");
        return "redirect:/customer";
    }


    @RequestMapping(value="/editCMR/{id}")
    public String edit(@PathVariable int id, Model m){
        Customer emp=cdao.getEmpById(id);
        m.addAttribute("command",emp);
        return "edit_customer";
    }

    @RequestMapping("/delete")
    public String deleteCustomerForm(@RequestParam long id) {
        cdao.delete((int) id);
        return "redirect:/customer";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Customer> result = cdao.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);
        return mav;
    }
}
