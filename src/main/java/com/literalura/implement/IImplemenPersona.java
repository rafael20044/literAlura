package com.literalura.implement;

import com.literalura.entidades.Persona;
import java.util.List;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public interface IImplemenPersona {
    
    public void guardar(Persona p);
    
    public List<Persona> buscarTodos();
}
