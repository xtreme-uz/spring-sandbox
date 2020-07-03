package com.example.restdocs;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Author: Rustambekov Avazbek
 * Date: 05/05/2020
 * Time: 13:10
 */

@RestController
@RequestMapping("/people")
public class PersonController {

    @GetMapping
    public List<Person> getAll() {
        return Arrays.asList(new Person(1, "John Doe"), new Person(2, "Alex Murphy"));
    }

    @GetMapping(path = "/{id}")
    public Person getPersonById(@PathVariable int id) {
        return new Person(id, "John Doe");
    }

    @PostMapping
    public Person save(@RequestBody Person person) {
        return person;
    }

}
