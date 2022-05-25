package com.example.services;

import java.util.List;

import com.example.entities.Persona;

public interface PersonaService {

    public List<Persona> findAll();

    public Persona findById(Long id);

    public void save(Persona persona);

}
