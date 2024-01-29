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


    //    @RequestMapping("/viewemp")
//    public String viewemp(Model m){
//        List<Emp> list=dao.getEmployees();
//        m.addAttribute("list",list);
//        return "viewemp";
//    }
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

    //      @RequestMapping(value="/editsave",method = RequestMethod.POST)
//    public String editsave(@ModelAttribute("emp") Emp emp, RedirectAttributes redirectAttributes){
//        int res = dao.update(emp);
//        redirectAttributes.addFlashAttribute("msg", res > 0 ? "Updated" : "Error");
//        return "redirect:/viewemp";
//    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editCustomerForm(@ModelAttribute("Customer") Customer cus, RedirectAttributes redirectAttributes) {
        int res = cdao.update(cus);
        return "redirect:/customer";
    }

    //    @RequestMapping(value="/editemp/{id}")
//    public String edit(@PathVariable int id, Model m){
//        Emp emp=dao.getEmpById(id);
//        m.addAttribute("command",emp);
//        return "empeditform";
//    }
    @RequestMapping(value = "/edit?id={id}")
    public String cedit(@PathVariable int id, Model m) {
Customer c = cdao.getEmpById(id);
        m.addAttribute("command",c);
        return "edit_customer";
    }

    @RequestMapping("/delete")
    public String deleteCustomerForm(@RequestParam long id) {
        cdao.delete((int) id);
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
