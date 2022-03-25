package uz.xtreme.jpa.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.xtreme.jpa.domain.Category;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @EntityGraph(value = "Category.tree")
    @Query("FROM Category c WHERE c.parent IS NULL")
    List<Category> findAllParentCategories();

}
