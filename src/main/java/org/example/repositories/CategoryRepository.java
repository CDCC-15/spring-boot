package org.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.example.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}