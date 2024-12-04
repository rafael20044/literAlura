package com.literalura.repositorio;

import com.literalura.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public interface RepoAutor extends JpaRepository<Persona, Integer>{
    
}
