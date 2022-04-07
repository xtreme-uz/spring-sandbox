package uz.xtreme.jpa.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.xtreme.jpa.domain.Community;

import java.util.Optional;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

    @EntityGraph(attributePaths = {"organizers", "members"})
    Optional<Community> findCommunityById(Long id);
}
