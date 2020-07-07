package uz.xtreme.mongodb;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: Rustambekov Avazbek
 * Date: 06/07/2020
 * Time: 16:18
 */

@Repository
public interface StudentRepository extends ReactiveMongoRepository<Student, String> {

    Flux<Student> findByFirstName(String firstName);
    Mono<Student> findOneByFirstName(String firstName);

}
