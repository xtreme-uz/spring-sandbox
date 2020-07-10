package uz.xtreme.mongodb;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.time.Duration;

/**
 * Author: Rustambekov Avazbek
 * Date: 06/07/2020
 * Time: 16:21
 */

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository repository;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @PostConstruct
    void config() {
        reactiveMongoTemplate.dropCollection("student")
                .then(
                        reactiveMongoTemplate.createCollection("student", CollectionOptions.empty().capped().size(4096).maxDocuments(10000))
                ).subscribe();
    }

    public Flux<Student> getAll() {
        return repository.findAllByFirstName("John").delayElements(Duration.ofSeconds(1));
    }

    public Mono<Student> getById(String id) {
        return repository.findById(id);
    }

    public Mono<Student> save(Student student) {
        return repository.insert(student);
    }

    public Mono<Student> save(String id, Student student) {
        student.setId(id);
        return repository.save(student);
    }

    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

}
