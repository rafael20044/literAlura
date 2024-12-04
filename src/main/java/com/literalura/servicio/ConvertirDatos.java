package com.literalura.servicio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public class ConvertirDatos implements IConvertirDatos{
    
    private final ObjectMapper mapper = new JsonMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return mapper.readValue(json, clase);
        } catch (JsonProcessingException ex) {
            System.out.println(ex.getCause());
        }
        return null;
    }
    
}
