package com.example.services;

import java.util.List;

import com.example.dao.PaisDao;
import com.example.entities.Pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisServiceImpl implements PaisService{

    @Autowired
    private PaisDao paisDao;

    @Override
    public List<Pais> findAll() {
        return paisDao.findAll();
    }
    
}
