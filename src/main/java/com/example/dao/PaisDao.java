package com.example.dao;

import com.example.entities.Pais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisDao extends JpaRepository<Pais,Long>{
    
}
