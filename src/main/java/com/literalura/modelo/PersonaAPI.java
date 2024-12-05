package com.literalura.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
 *
 * @author Rafael Barragán Acevedos
 */
public record PersonaAPI(
        
        @JsonAlias("birth_year") Integer fechaNacimiento,
        @JsonAlias("death_year") Integer fechaMuerte,
        @JsonAlias("name") String nombre
        ) {
    
}

//  "birth_year": <number or null>,
//  "death_year": <number or null>,
//  "name": <string>
