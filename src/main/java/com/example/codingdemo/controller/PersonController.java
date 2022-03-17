package com.example.codingdemo.controller;

import com.example.codingdemo.data.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class PersonController {

    @Resource
    PersonRepository personRepo;

    @RequestMapping("person")
    public String findOnePerson(@RequestParam Long id, Model model) {
        model.addAttribute("person", personRepo.getById(id));
        return "person";
    }

    @RequestMapping(value = "persons")
    public String FindAllPersons(Model model) {
        model.addAttribute("person", personRepo.findAll());
        return "persons";
    }

    public String findPersons(Model model) {
        model.addAttribute("persons", personRepo.findAll());
        return "persons";

        /* The reason why I chose to use @NotNull Explained:
         * An element annotated with NotNull claims null value is forbidden to return (for methods), pass to (parameters)
         * and hold (local variables and fields). Apart from documentation purposes this annotation is intended to be used by
         * static analysis tools to validate against probable runtime errors and element contract violations.
         */
    }


}
