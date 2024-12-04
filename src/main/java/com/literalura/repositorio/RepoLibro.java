package com.literalura.repositorio;

import com.literalura.entidades.Libro;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public interface RepoLibro extends JpaRepository<Libro, Integer>{
    @Query("SELECT l FROM Libro l WHERE l.titulo ILIKE :titulo")
    public Optional<Libro> buscarPorTitulo(String titulo);

}
