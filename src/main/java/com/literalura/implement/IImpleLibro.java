package com.literalura.implement;

import com.literalura.entidades.Libro;
import java.util.Optional;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public interface IImpleLibro{
    
    public void crear(Libro l);
    
    public void editar(Libro l);
    
    public Optional<Libro> buscar(Integer id);
    
    public void eliminar(Integer id);
    
    public Optional<Libro>buscarPorTitulo(String titulo);
}
