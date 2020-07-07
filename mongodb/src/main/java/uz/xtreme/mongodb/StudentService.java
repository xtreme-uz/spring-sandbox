package uz.xtreme.mongodb;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: Rustambekov Avazbek
 * Date: 06/07/2020
 * Time: 16:21
 */

@Service
@Transactional
@AllArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public Flux<Student> getAll() {
        return repository.findAll().switchIfEmpty(Flux.empty());
    }

    public Mono<Student> getById(String id) {
        return repository.findById(id);
    }

    public Mono<Student> save(Student student) {
        return repository.save(student);
    }

    public Mono<Student> save(String id, Student student) {
        student.setId(id);
        return repository.save(student);
    }

    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

}
