package uz.xtreme.mongodb;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: Rustambekov Avazbek
 * Date: 06/07/2020
 * Time: 16:09
 */

@AllArgsConstructor
@RequestMapping("/students")
@RestController
public class RegistrationController {

    private final StudentService service;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Student> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Student> getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Mono<Student> update(@PathVariable String id, @RequestBody Student student) {
        return service.save(id, student);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Student> create(@RequestBody Student student) {
        return service.save(student);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }

}
