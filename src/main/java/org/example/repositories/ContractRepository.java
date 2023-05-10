package org.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.example.model.Contract;

public interface ContractRepository extends CrudRepository<Contract, Long> {
}