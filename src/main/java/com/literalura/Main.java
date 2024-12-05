package com.literalura;

import com.literalura.entidades.Libro;
import com.literalura.entidades.Persona;
import com.literalura.modelo.LibroAPI;
import com.literalura.modelo.PersonaAPI;
import com.literalura.servicio.CargarDatosApi;
import com.literalura.servicio.ConvertirDatos;
import com.literalura.servicio.LibroServicio;
import com.literalura.servicio.PersonaServicio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private LibroServicio servicio;
    private PersonaServicio servicioP;

    public Main(LibroServicio servicio, PersonaServicio servicioP) {
        this.servicio = servicio;
        this.servicioP = servicioP;
    }

    public void inicio() {
        Scanner sc = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        int op;
        do {
            String menu = """
                Elije la opcion usando numeros
                
                1. Buscar libro por titulo
                2. Listar libros registrados
                3. Listar autores registrados
                4. Listar autores vivos en un determinado año
                5. Listar libros por idiomas
                6. Salir
                  """;
            System.out.println(menu);
            System.out.println("Digite una opcion: ");
            op = scInt.nextInt();
            switch (op) {
                case 1 -> {
                    try {
                        CargarDatosApi cargarDatos = new CargarDatosApi();
                        System.out.println("Digite el titulo: ");
                        String titulo = sc.nextLine();
                        Optional<Libro> l = servicio.buscarPorTitulo(titulo);
                        if (l.isPresent()) {
                            System.out.println("Este libro ya esta en la base de datos");
                            pausa();
                        } else {
                            String json = cargarDatos.buscarLibro(titulo);
                            convertir(json);
                            pausa();
                        }
                    } catch (IOException | InterruptedException e) {
                        System.out.println(e.getCause());
                    }
                }
                case 2 -> {
                    List<Libro> libros = servicio.buscarTodos();
                    libros.forEach(libro -> {
                        System.out.println("--------Libro--------");
                        System.out.println("Titulo: " + libro.getTitulo());
                        System.out.println("Autor: " + libro.getAutores());
                        System.out.println("Idioma: " + libro.getIdiomas());
                        System.out.println("Numero de descargas: " + libro.getDescargas());
                        System.out.println("---------------------");
                    });
                    pausa();
                }
                case 3 -> {
                    List<Persona> autores = servicioP.buscarTodos();
                    autores.forEach(autor -> {
                        System.out.println("--------Autor--------");
                        System.out.println("Nombre: " + autor.getNombre());
                        System.out.println("Año de nacimiento: " + autor.getFechaNacimiento());
                        System.out.println("Año de fallecimiento: " + autor.getFechaMuerte());
                        System.out.println("----------------------");
                    });
                    pausa();
                }
                case 4 -> {
                    System.out.println("Digite el año: ");
                    Integer año = scInt.nextInt();
                    List<Persona> autores = servicioP.buscarTodos();
                    autores.stream().filter(autor -> autor.getFechaMuerte() > año)
                            .forEach(autor -> {
                                System.out.println("--------Autor--------");
                                System.out.println("Nombre: " + autor.getNombre());
                                System.out.println("Año de nacimiento: " + autor.getFechaNacimiento());
                                System.out.println("Año de fallecimiento: " + autor.getFechaMuerte());
                                System.out.println("----------------------");
                            });
                    pausa();
                }
                case 5 -> {
                    System.out.println("Digite un idioma: es(español), en(ingles), fr(frances), pt(portuges)");
                    String opcion = sc.next();
                    List<Libro> libros = servicio.buscarTodos();
                    libros.stream().filter(libro -> libro.getIdiomas().contains(opcion)).forEach(libro -> {
                        System.out.println("--------Libro--------");
                        System.out.println("Titulo: " + libro.getTitulo());
                        System.out.println("Autor: " + libro.getAutores());
                        System.out.println("Idioma: " + libro.getIdiomas());
                        System.out.println("Numero de descargas: " + libro.getDescargas());
                        System.out.println("---------------------");
                    });
                    pausa();
                }
            }
        } while (op != 6);
    }

    private void convertir(String json) {
        ConvertirDatos con = new ConvertirDatos();
        if (json.equals("{}")) {
            System.out.println("Libro no encontrado en la API ni en base de datos U_U");
            return;
        }
        LibroAPI l = con.obtenerDatos(json, LibroAPI.class);
        if (l != null) {
            List<Persona> autores = new ArrayList<>();
            List<PersonaAPI> autoresAPI = l.autores();
            List<Persona> traductores = new ArrayList<>();
            List<PersonaAPI> traductoresAPI = l.traductores();

            autoresAPI.forEach(autor -> {
                Persona p = new Persona(autor.nombre(), autor.fechaNacimiento(), autor.fechaMuerte());
                servicioP.guardar(p);
                autores.add(p);
            });

            traductoresAPI.forEach(traductor -> {
                Persona p = new Persona(traductor.nombre(), traductor.fechaNacimiento(),
                        traductor.fechaMuerte());
                servicioP.guardar(p);
                traductores.add(p);
            });

            Libro libro = new Libro(l.id(), l.titulo(), autores, traductores, l.subject(), l.estanteria(),
                    l.idiomas(), l.copyright(), l.tipo(), l.descargas());
            System.out.println("--------Libro--------");
            System.out.println("Titulo: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutores());
            System.out.println("Idioma: " + libro.getIdiomas());
            System.out.println("Numero de descargas: " + libro.getDescargas());
            System.out.println("---------------------");
            servicio.crear(libro);
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    private void pausa() {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("precione enter...");
        sc.nextLine();
    }
}
