package uz.xtreme.jpa.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import uz.xtreme.jpa.domain.Community;
import uz.xtreme.jpa.repository.CommunityRepository;

@Component
public class ApplicationComponent {

    //save child records when parent record is deleted
    @Bean
    CommandLineRunner parentChildAssociation(CommunityRepository parentRepository) {
        return args -> {
            Community parent = parentRepository.findCommunityById(1L).orElseThrow();
            parentRepository.delete(parent);
        };
    }
}
