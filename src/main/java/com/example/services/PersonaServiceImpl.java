package com.example.services;

import java.util.List;

import com.example.dao.PersonaDao;
import com.example.entities.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaDao personaDao;

    @Override
    public List<Persona> findAll() {
        return personaDao.findAll();
    }

    @Override
    public Persona findById(Long id) {
        return personaDao.findById(id).get();
    }

    @Override
    public void save(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    public void delete(Persona persona) {
        personaDao.delete(persona);      
    }
    
}
