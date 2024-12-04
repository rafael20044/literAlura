package com.literalura.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author Rafael Barragán Acevedo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroAPI(
        
        @JsonAlias("id") Integer id,
        @JsonAlias("title") String titulo,
        @JsonAlias("subjects") List<String> subject,
        @JsonAlias("authors") List<PersonaAPI> autores,
        @JsonAlias("translators") List<PersonaAPI> traductores,
        @JsonAlias("bookshelves") List<String> estanteria,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("copyright") boolean copyright,
        @JsonAlias("media_type") String tipo,
        @JsonAlias("download_count")Integer descargas
        ) {
    
}



//  "id": <number of Project Gutenberg ID>,
//  "title": <string>,
//  "subjects": <array of strings>,
//  "authors": <array of Persons>,
//  "translators": <array of Persons>,
//  "bookshelves": <array of strings>,
//  "languages": <array of strings>,
//  "copyright": <boolean or null>,
//  "media_type": <string>,
//  "formats": <Format>,
//  "download_count": <number>
