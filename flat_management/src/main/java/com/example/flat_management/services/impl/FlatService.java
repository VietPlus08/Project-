package com.example.flat_management.services.impl;

import com.example.flat_management.models.Flat;
import com.example.flat_management.repository.IBFlatRepository;
import com.example.flat_management.repository.impl.FlatRepository;
import com.example.flat_management.services.IBFlatServices;
import com.example.flat_management.utils.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlatService implements IBFlatServices<Flat> {
    IBFlatRepository<Flat> repository = new FlatRepository();
    Valid valid = new Valid();

    @Override
    public List<Flat> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public List<Flat> Search(String id, String status) {
        return repository.Search(id,status);
    }

    @Override
    public Map<String, String> create(Flat flat) {
        Map<String,String> error = valid.getValidation(flat);
        List<Flat> list = repository.Search(flat.getId(),"");
        if (error.isEmpty() & list.isEmpty()){
            repository.create(flat);
            return error;
        }
//        if list ko empty thi thuc hien update
        if (error.isEmpty()){
            repository.delete(flat.getId());
            repository.create(flat);
        }
        return error;
    }

    @Override
    public Flat findById(String id, String status) {
        List<Flat> list = repository.Search(id,status);
        return list.get(0);
    }
}
