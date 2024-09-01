package com.example.crud.serviceimp;

import com.example.crud.dto.Cruddto;
import com.example.crud.entity.Crudentity;
import com.example.crud.repo.Crudrepo;
import com.example.crud.service.Crudservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Crudserviceimp implements Crudservice {
    @Autowired
    public Crudrepo crudrepo;
    @Override
    public Crudentity createUser(Cruddto cruddto) {
        Crudentity crudentity=new Crudentity();
        crudentity.setId(cruddto.getId());
        crudentity.setName(cruddto.getName());
        crudentity.setEmail(cruddto.getEmail());
        crudentity.setPassword(cruddto.getPassword());
        return crudrepo.save(crudentity);
    }

    @Override
    public List<Crudentity> getAllUser() {
        return crudrepo.findAll();
    }

    @Override
    public Optional<Crudentity> getParticularUser(int x) {
        return crudrepo.findById(x);
    }

    @Override
    public Crudentity updateUser(int x, Cruddto cruddto) {
//        Crudentity crudentity=new Crudentity();
//        if(crudrepo.existsById(x)){
//            crudentity.setId(x);
//            crudentity.setName(cruddto.getName());
//            crudentity.setEmail(cruddto.getEmail());
//            crudentity.setPassword(cruddto.getPassword());
//            return crudrepo.save(crudentity);
//        }
        Optional<Crudentity> existingUser = crudrepo.findById(x);
        if (existingUser.isPresent()) {
            Crudentity crudentity = existingUser.get();
            crudentity.setName(cruddto.getName());
            crudentity.setEmail(cruddto.getEmail());
            crudentity.setPassword(cruddto.getPassword());
            return crudrepo.save(crudentity);
        }

        return null;
    }

    @Override
    public void deleteUser(int id) {
        crudrepo.deleteById(id);
    }


}
