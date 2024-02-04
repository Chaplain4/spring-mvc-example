package com.journaldev.spring.controller;

import com.journaldev.spring.dao.EmpDao;
import com.journaldev.spring.dao.PizzaDAO;
import com.journaldev.spring.model.Emp;
import com.journaldev.spring.model.Pizza;
import com.journaldev.spring.util.EmailUtils;
import com.journaldev.spring.util.EncryptDecryptUtils;
import com.journaldev.spring.util.MathUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@EnableWebMvc
public class PizzaController {
    private static final Logger logger = LogManager.getLogger(EmpController.class);

    @Autowired
    private PizzaDAO dao; //will inject dao from XML file


    /*It displays a form to input data, here "command" is a reserved request attribute
     *which is used to display object data into form
     */
    @RequestMapping("/pizzaform")
    public String showPizza(Model m) {
        m.addAttribute("command", new Pizza());
        return "pizzaform";
    }

    /*It saves object into database. The @ModelAttribute puts request data
     *  into model object. You need to mention RequestMethod.POST method
     *  because default request is GET*/
    @RequestMapping(value = "/savePizza", method = RequestMethod.POST)
    public String save(@ModelAttribute("emp") Pizza p) {
        try {
            dao.save(p);
            logger.info("S = {}", p.toString() + " saved successfully");
        } catch (Throwable t) {
            logger.error("S = {}", p.toString() + "save error. Details: " + t.getMessage());
        }
        return "redirect:/viewpizza";//will redirect to viewemp request mapping
    }

    /* It provides list of employees in model object */
    @RequestMapping("/viewpizza")
    public String viewpizza(Model m) {
        List<Pizza> list = dao.getAll();
        m.addAttribute("list", list);
        return "viewpizza";
    }

    /* It displays object data into form for the given id.
     * The @PathVariable puts URL data into variable.*/
    @RequestMapping(value = "/editpizza/{id}")
    public String edit(@PathVariable int id, Model m) {
        try {
            Pizza p = dao.getPizzaById(id);
            m.addAttribute("command", p);
            logger.info("S = {}", p.toString() + " found successfully");
        } catch (Throwable t) {
            logger.error("S = {}", "Pizza with id #" + id + " search error. Details: " + t.getMessage());
        }
        return "pizzaeditform";
    }

    /* It updates model object. */
    @RequestMapping(value = "/editsavepizza", method = RequestMethod.POST)
    public String editsave(@ModelAttribute("pizza") Pizza pizza, RedirectAttributes redirectAttributes) {
        try {
            int res = dao.update(pizza);
            redirectAttributes.addFlashAttribute("msg", res > 0 ? "Updated" : "Error");
            logger.info("S = {}", pizza.toString() + " updated successfully");
        } catch (Throwable t) {
            logger.error("S = {}", pizza.toString() + "save error. Details: " + t.getMessage());
        }
        return "redirect:/viewemp";
    }

    /* It deletes record for the given id in URL and redirects to /viewpizza */
    @RequestMapping(value = "/deletepizza/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        try {
            dao.delete(id);
            logger.info("S = {}", "Pizza with id #" + id + " deleted successfully.");
        } catch (Throwable t) {
            logger.error("S = {}", "Pizza with id #" + id + " delete error. Details: " + t.getMessage());
        }
        return "redirect:/viewpizza";
    }
}