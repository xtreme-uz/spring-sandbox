package uz.xtreme.mongodb;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
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

    @Tailable
    Flux<Student> findAllByFirstName(String firstName);
    Mono<Student> findOneByFirstName(String firstName);

}
