package com.heroku.demo;

import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class PersonController {

    private PersonRepository repository;

    @Autowired
    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value="/people", method = RequestMethod.GET)
    public String demos(ModelMap model) {
        List<Person> people = repository.findAll();
        model.addAttribute("people", people);
        return "list";
    }

    @RequestMapping(value="/people/new", method = RequestMethod.GET)
    public String home(ModelMap model) {
        model.addAttribute("person", new Person());
        return "add";
    }

    @RequestMapping(value="/people/new", method = RequestMethod.POST)
    public String insertData(ModelMap model, 
                             @ModelAttribute("person") @Valid Person person,
                             BindingResult result) {
        if (!result.hasErrors()) {
            repository.save(person);
        }
        return "redirect:/people";
    }
}
