package com.example.crud.service;

import com.example.crud.dto.Cruddto;
import com.example.crud.entity.Crudentity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface Crudservice {
    Crudentity createUser(Cruddto cruddto);
    List<Crudentity> getAllUser();
    Optional<Crudentity> getParticularUser(int x);
    Crudentity updateUser(int x,Cruddto cruddto);
    void deleteUser(int id);
}
