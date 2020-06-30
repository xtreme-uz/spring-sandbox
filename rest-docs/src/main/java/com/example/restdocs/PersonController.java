package com.example.restdocs;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Rustambekov Avazbek
 * Date: 05/05/2020
 * Time: 13:10
 */

@RestController
@RequestMapping("/persons/")
public class PersonController {

    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    public Person getPersonById(@PathVariable int id) {
        return new Person(id, "John Doe");
    }

}
