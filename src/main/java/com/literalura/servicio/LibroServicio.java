package com.literalura.servicio;

import com.literalura.implement.IImpleLibro;
import com.literalura.entidades.Libro;
import com.literalura.repositorio.RepoLibro;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafael Barragán Acevedo
 */
@Service
public class LibroServicio implements IImpleLibro{
    @Autowired
    private RepoLibro repoLibro;

    public LibroServicio() {
    }

    @Override
    public void crear(Libro l) {
        repoLibro.save(l);
    }

    @Override
    public void editar(Libro l) {
        repoLibro.save(l);
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Libro> buscar(Integer id) {
        Optional<Libro> o = repoLibro.findById(id).or(null);
        return o;
    }

    @Override
    public Optional<Libro> buscarPorTitulo(String titulo) {
        return repoLibro.buscarPorTitulo(titulo);
    }

}
