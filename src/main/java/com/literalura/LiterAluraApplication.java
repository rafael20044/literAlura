package com.literalura;

import com.literalura.servicio.LibroServicio;
import com.literalura.servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner{

    @Autowired
    private LibroServicio sevicio;
    @Autowired
    private PersonaServicio servioP;
    
    public static void main(String[] args) {
        SpringApplication.run(LiterAluraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Main m = new Main(sevicio, servioP);
        m.inicio();
    }
    
}
