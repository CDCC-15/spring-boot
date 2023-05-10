package org.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.example.model.SubCategory;

public interface SubCategoryRepository extends CrudRepository<SubCategory, Long> {
}