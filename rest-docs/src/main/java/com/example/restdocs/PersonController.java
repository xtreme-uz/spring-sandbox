package com.example.restdocs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Author: Rustambekov Avazbek
 * Date: 05/05/2020
 * Time: 13:10
 */

@RestController
@RequestMapping("/people")
public class PersonController {

    @GetMapping(produces = "application/json")
    public List<Person> getAll() {
        return Arrays.asList(new Person(1, "John Doe"), new Person(2, "Alex Murphy"));
    }

    @RequestMapping(method = GET, path = "/{id}", produces = "application/json")
    public Person getPersonById(@PathVariable int id) {
        return new Person(id, "John Doe");
    }

}
