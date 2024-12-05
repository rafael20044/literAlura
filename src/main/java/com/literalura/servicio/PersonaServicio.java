/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.literalura.servicio;

import com.literalura.entidades.Persona;
import com.literalura.implement.IImplemenPersona;
import com.literalura.repositorio.RepoAutor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafael Barragán Acevedo
 */
@Service
public class PersonaServicio implements IImplemenPersona{

    @Autowired
    private RepoAutor repo;
    
    @Override
    public void guardar(Persona p) {
        repo.save(p);
    }

    @Override
    public List<Persona> buscarTodos() {
        return repo.findAll();
    }
    
}
