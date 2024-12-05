package com.literalura.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

/**
 *
 * @author Rafael Barragán Acevedo
 */
@Entity
public class Libro {
    @Id
    private Integer id;
    
    private String titulo;
    
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Persona> autores;
    
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Persona> traductores;
    
    private List<String> subjects;
    private List<String> estanteria;
    private List<String> idiomas;
    private Boolean copyright;
    private String tipo;
    private int descargas;
    

    public Libro() {
    }

    public Libro(Integer id, String titulo, List<Persona> autores, List<Persona> traductores, List<String> subjects, List<String> estanteria, List<String> idiomas, Boolean copyright, String tipo, int descargas) {
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
        this.traductores = traductores;
        this.subjects = subjects;
        this.estanteria = estanteria;
        this.idiomas = idiomas;
        this.copyright = copyright;
        this.tipo = tipo;
        this.descargas = descargas;
    }

    public List<Persona> getAutores() {
        return autores;
    }

    public void setAutores(List<Persona> autores) {
        this.autores = autores;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Persona> getTraductores() {
        return traductores;
    }

    public void setTraductores(List<Persona> traductores) {
        this.traductores = traductores;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getEstanteria() {
        return estanteria;
    }

    public void setEstanteria(List<String> estanteria) {
        this.estanteria = estanteria;
    }

    public Boolean getCopyright() {
        return copyright;
    }

    public void setCopyright(Boolean copyright) {
        this.copyright = copyright;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDescargas() {
        return descargas;
    }

    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }
    
    

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", autores=" + autores + ", traductores=" + traductores + ", subjects=" + subjects + ", estanteria=" + estanteria + ", idiomas=" + idiomas + ", copyright=" + copyright + ", tipo=" + tipo + ", descargas=" + descargas + '}';
    }
    
    
    
}
