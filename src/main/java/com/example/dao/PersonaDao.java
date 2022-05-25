package com.example.dao;

import com.example.entities.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PersonaDao extends JpaRepository<Persona,Long> {
    
}
