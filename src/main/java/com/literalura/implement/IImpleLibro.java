package com.literalura.implement;

import com.literalura.entidades.Libro;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public interface IImpleLibro{
    
    public void crear(Libro l);
    
    public Optional<Libro>buscarPorTitulo(String titulo);
    
    public List<Libro> buscarTodos();
}
