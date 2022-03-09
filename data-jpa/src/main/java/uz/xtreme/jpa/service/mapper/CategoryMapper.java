package uz.xtreme.jpa.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.xtreme.jpa.domain.Category;
import uz.xtreme.jpa.service.dto.CategoryTo;
import uz.xtreme.jpa.service.dto.SimpleCategoryTo;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    Category fromCreateDto(CategoryTo category);

    @Mapping(target = "parentId", source = "parent.id")
    CategoryTo toDto(Category category);

    Category fromDto(CategoryTo category);

    List<SimpleCategoryTo> toSimpleCategory(List<Category> categories);
}
