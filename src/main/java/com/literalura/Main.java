package com.literalura;

import com.literalura.entidades.Libro;
import com.literalura.entidades.Persona;
import com.literalura.modelo.LibroAPI;
import com.literalura.modelo.PersonaAPI;
import com.literalura.servicio.CargarDatosApi;
import com.literalura.servicio.ConvertirDatos;
import com.literalura.servicio.LibroServicio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class Main {
    private LibroServicio servicio ;

    public Main(LibroServicio servicio) {
        this.servicio = servicio;
    }
    
    

    public void inicio() {
        Scanner sc = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        int op;
        do {
            String menu = """
                Elije la opcion usando numeros
                
                1. Buscar libro por titulo
                2. Salir         
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
                            Libro libro = l.get();
                            System.out.println(libro);
                            pausa();
                            return;
                        }
                        String json = cargarDatos.buscarLibro(titulo);
                        convertir(json);
                        pausa();
                    } catch (IOException | InterruptedException e) {
                        System.out.println(e.getCause());
                    }
                }
            }
        } while (op != 2);
    }

    private void convertir(String json) {
        ConvertirDatos con = new ConvertirDatos();
        System.out.println(json);
        if (json.equals("{}")) {
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
                autores.add(p);
            });

            traductoresAPI.forEach(traductor -> {
                Persona p = new Persona(traductor.nombre(), traductor.fechaNacimiento(), traductor.fechaMuerte());
                traductores.add(p);
            });

            Libro libro = new Libro(l.id(), l.titulo(), autores, traductores, l.subject(), l.estanteria(),
                    l.idiomas(), l.copyright(), l.tipo(), l.descargas());
            servicio.crear(libro);
        }else{
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
