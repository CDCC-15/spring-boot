package org.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.example.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
}