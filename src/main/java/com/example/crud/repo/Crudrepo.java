package com.example.crud.repo;

import com.example.crud.entity.Crudentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface Crudrepo extends JpaRepository<Crudentity, Integer> {

    @Query("Select c from Crudentity c where c.name=:name")
    Optional<Crudentity> findUserByName(String name);
}
