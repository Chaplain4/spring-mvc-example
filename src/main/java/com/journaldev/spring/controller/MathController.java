package com.journaldev.spring.controller;

import com.journaldev.spring.model.Equation;
import com.journaldev.spring.model.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class MathController {
    private static Logger logger = LogManager.getLogger(EmpController.class);

    //написать JSP форму для ввода а, b, c.
    //дать решение - 0,1,2 корня
    //1 метод - показать форму гетом
    //2 метод - принять параметры и посчитать
    //3 метод - вывести, дать href на try again

    @RequestMapping(value = "/math", method = RequestMethod.GET)
    public String math() {
        System.out.println("math");
        return "math";
    }

    @RequestMapping(value = "/math", method = RequestMethod.POST)
    public String solve(@Validated Equation equation, Model model) {
        String solutions = "";
        if (equation.getA() == 0 && equation.getB() == 0) {
            solutions = "no roots";
            model.addAttribute("solutions", solutions);
        } else {
            double d = (equation.getB() * equation.getB()) - (4.0 * equation.getA() * equation.getC());
            if ((equation.getA() == 0 && equation.getB() == 0) || d < 0) {
                logger.error("equation.getA() == 0 && equation.getB() == 0) || d < 0");
                solutions = "no roots";
                model.addAttribute("solutions", solutions);
            } else if (equation.getA() == 0) {
                solutions = String.valueOf((-1.0 * equation.getC() / equation.getB()));
                model.addAttribute("solutions", solutions);
            } else if (d == 0) {
                solutions = String.valueOf(((-1.0 * equation.getB()) / (2 * equation.getA())));
                model.addAttribute("solutions", solutions);
            } else {
                solutions = (((-1.0 * equation.getB()) + Math.sqrt(d)) / (2.0 * equation.getA())) + ", " + ((-1.0 * equation.getB()) - Math.sqrt(d)) / (2.0 * equation.getA());
                model.addAttribute("solutions", solutions);
            }
        }
        return "solution";
    }

//    @RequestMapping(value = "/math", method = RequestMethod.GET)
//    public String solve(@RequestParam double a,@RequestParam double b,@RequestParam double c, Model model) {
//        String solutions = "";
//        Equation equation = new Equation();
//        equation.setA(a);
//        equation.setB(b);
//        equation.setC(c);
//        if (equation.getA() == 0 && equation.getB() == 0) {
//            solutions = "no roots";
//            model.addAttribute("solutions", solutions);
//        } else {
//            double d = (equation.getB() * equation.getB()) - (4.0 * equation.getA() * equation.getC());
//            if ((equation.getA() == 0 && equation.getB() == 0) || d < 0) {
//                solutions = "no roots";
//                model.addAttribute("solutions", solutions);
//            } else if (equation.getA() == 0) {
//                solutions = String.valueOf((-1.0 * equation.getC() / equation.getB()));
//                model.addAttribute("solutions", solutions);
//            } else if (d == 0) {
//                solutions = String.valueOf(((-1.0 * equation.getB()) / (2 * equation.getA())));
//                model.addAttribute("solutions", solutions);
//            } else {
//                solutions = (((-1.0 * equation.getB()) + Math.sqrt(d)) / (2.0 * equation.getA())) + ", " + ((-1.0 * equation.getB()) - Math.sqrt(d)) / (2.0 * equation.getA());
//                model.addAttribute("solutions", solutions);
//            }
//        }
//        return "solution";
//    }

    @RequestMapping(value = "/triangle1", method = RequestMethod.GET)
    public String triangle() {
        System.out.println("triangle");
        return "triangle";
    }

    @RequestMapping(value = "/triangle", method = RequestMethod.POST)
    public String solve(@Validated Triangle triangle, Model model) {
        String solutions = "";
        if ((triangle.getA() + triangle.getB()) > triangle.getC() && (triangle.getC() + triangle.getB()) > triangle.getA() && (triangle.getA() + triangle.getC()) > triangle.getB()) {
            //S = √(p * (p — a) * (p — b) * (p — c)).
            Double a = triangle.getA();
            Double b = triangle.getB();
            Double c = triangle.getC();
            Double p = (a + b + c) / 2.0;
            solutions = "" + Math.sqrt(p * (p - a) * (p - b) * (p - c));
        } else {
            solutions = "invalid triangle";
        }
        model.addAttribute("solutions", solutions);
        return "triangle_solution";
    }

    @RequestMapping(value = "/calc_sum", method = RequestMethod.GET)
    public String solve(@RequestParam List<Integer> nums, Model model) {
        model.addAttribute("msg", "Size: " + nums.size());
        return "result";
    }


    @RequestMapping(value = "/print_all", method = RequestMethod.GET)
    public String solve9(@RequestParam Map<String, String> all, Model model) {
        StringBuilder result = new StringBuilder(128);
        all.forEach((k, v) -> {
            result.append(" Key : " + k);
            result.append(" Value : " + v + "<br>");
        });
        model.addAttribute("msg", "All pairs: <br>" + result.toString());
        return "result";
    }

    @RequestMapping(value = "/print_all", method = RequestMethod.POST)
    public String solve(@RequestParam Map<String, String> all, Model model) {
        StringBuilder result = new StringBuilder(128);
        all.forEach((k, v) -> {
            result.append(" Key : " + k);
            result.append(" Value : " + v + "<br>");
        });
        model.addAttribute("msg", "All pairs: <br>" + result.toString());
        return "result";
    }
}
