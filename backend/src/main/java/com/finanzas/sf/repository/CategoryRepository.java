package com.finanzas.sf.repository;

import org.springframework.data.repository.CrudRepository;

import com.finanzas.sf.model.Category;
import com.finanzas.sf.model.User;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    List<Category> findCategoryByUserAndState(User user, Integer estado);
    Optional<Category> findCategoryByIdCategoryAndState(Long idCategory, Integer state);
}
