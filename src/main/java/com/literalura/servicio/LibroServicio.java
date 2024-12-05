package com.literalura.servicio;

import com.literalura.implement.IImpleLibro;
import com.literalura.entidades.Libro;
import com.literalura.repositorio.RepoLibro;
import java.util.List;
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
    public Optional<Libro> buscarPorTitulo(String titulo) {
        return repoLibro.buscarPorTitulo(titulo);
    }

    @Override
    public List<Libro> buscarTodos() {
        return repoLibro.findAll();
    }

}
