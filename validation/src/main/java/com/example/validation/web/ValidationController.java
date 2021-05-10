package com.example.validation.web;

import com.example.validation.dto.AddressCreateTo;
import com.example.validation.dto.EventCreateTo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ValidationController {

    @PostMapping("/address")
    public AddressCreateTo createAddress(@Valid @RequestBody AddressCreateTo to) {
        return to;
    }

    @PostMapping("/event")
    public EventCreateTo createEvent(@Valid @RequestBody EventCreateTo to) {
        return to;
    }

}
