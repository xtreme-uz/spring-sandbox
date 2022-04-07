package uz.xtreme.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uz.xtreme.jpa.domain.Community;
import uz.xtreme.jpa.repository.CommunityRepository;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	//save child records when parent record is deleted
	@Bean
	CommandLineRunner parentChildAssociation(CommunityRepository parentRepository) {
		return args -> {
			Community parent = parentRepository.findCommunityById(1L).orElseThrow();
			parentRepository.delete(parent);
		};
	}

}
