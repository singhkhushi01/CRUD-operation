package com.example.crud.repo;

import com.example.crud.entity.Crudentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Crudrepo extends JpaRepository<Crudentity, Integer> {
}
