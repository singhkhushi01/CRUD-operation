package com.example.crud.controller;

import com.example.crud.dto.Cruddto;
import com.example.crud.entity.Crudentity;
import com.example.crud.service.Crudservice;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        if(crudentity.isPresent()){
            return ResponseEntity.status(200).body(crudentity.get());
        }else{
            return ResponseEntity.status(400).build();
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Crudentity> updateDetail(@PathVariable("id") int x, @RequestBody Cruddto cruddto){
        Crudentity crudentity=crudservice.updateUser(x, cruddto);
        if(crudentity!=null)
            return ResponseEntity.status(200).body(crudentity);
        else
            return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable int id){
        crudservice.deleteUser(id);

        Map<String,String> map=new HashMap<>();
        map.put("Status","Successful");
        return new ResponseEntity<>(map,HttpStatus.OK);
    }

    @GetMapping("/readbyname")
    public ResponseEntity<Crudentity> getByName(@RequestParam String name){
        Optional<Crudentity> crudentity=crudservice.getParticularName(name);
        if(crudentity.isPresent()){
            return ResponseEntity.status(200).body(crudentity.get());
        }else{
            return ResponseEntity.status(404).build();
        }
    }

    @PatchMapping("/patching/{x}")
    public ResponseEntity<Crudentity> patching(@PathVariable("x") int id,@RequestBody Cruddto cruddto){
        Crudentity crudentity=crudservice.patchUser(id,cruddto);
        if(crudentity!=null){
            return ResponseEntity.status(200).body(crudentity);
        }else{

            return ResponseEntity.status(404).build();
        }
    }

}
