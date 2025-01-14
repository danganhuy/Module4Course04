package huy.module4course04.controller;

import huy.module4course04.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class Exercise1Controller {
    @GetMapping(value = "/showForm")
    public String showForm(ModelMap model) {
        model.addAttribute("employee", new Employee());
        return "exercise1/create";
    }

    @PostMapping(value = "/addEmployee")
    public String submit(@ModelAttribute("employee") Employee employee, ModelMap model) {
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        return "exercise1/info";
    }
}
