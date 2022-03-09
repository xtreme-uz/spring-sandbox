package uz.xtreme.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.xtreme.jpa.domain.Category;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByParentIsNull();

}
