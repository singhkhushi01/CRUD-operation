package com.example.crud.controller;

import com.example.crud.dto.Cruddto;
import com.example.crud.entity.Crudentity;
import com.example.crud.service.Crudservice;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Crudcontroller {
    @Autowired
    public Crudservice crudservice;
    @PostMapping("/create")
    public ResponseEntity<Crudentity> createDetail(@RequestBody Cruddto cruddto){
        Crudentity crudentity=crudservice.createUser(cruddto);
        return ResponseEntity.status(200).body(crudentity);
    }

    @GetMapping("/read")
    public List<Crudentity> getAllUsers(){
        return crudservice.getAllUser();
    }

    @GetMapping("/reading/{x}")
    public ResponseEntity<Crudentity> getParticular(@PathVariable int x){
        Optional<Crudentity> crudentity=crudservice.getParticularUser(x);
//        if(crudentity.isPresent()){
//            return ResponseEntity.status(200).build();
//        }else{
//            return ResponseEntity.status(400).build();
//        }
        return crudentity.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Crudentity> updateDetail(@PathVariable int x, @RequestBody Cruddto cruddto){
        Crudentity crudentity=crudservice.updateUser(x, cruddto);
        if(crudentity!=null)
            return ResponseEntity.status(200).body(crudentity);
        else
            return ResponseEntity.status(400).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id){
        crudservice.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
