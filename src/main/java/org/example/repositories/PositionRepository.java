package org.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.example.model.Position;

public interface PositionRepository extends CrudRepository<Position, Long> {
}