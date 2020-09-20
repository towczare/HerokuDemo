package com.heroku.demo.people;

import javax.validation.Valid;

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

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value="/people", method = RequestMethod.GET)
    public String demos(ModelMap model) {
        model.addAttribute("people", personService.getPeople());
        return "list";
    }

    @RequestMapping(value="/people/new", method = RequestMethod.GET)
    public String home(ModelMap model) {
        model.addAttribute("person", new PersonForm());
        return "add";
    }

    @RequestMapping(value="/people/new", method = RequestMethod.POST)
    public String insertData(ModelMap model, 
                             @ModelAttribute("person") @Valid PersonForm person,
                             BindingResult result) {
        if (!result.hasErrors()) {
            personService.save(person);
        }else {
            return "add";
        }
        return "redirect:/people";
    }
}
