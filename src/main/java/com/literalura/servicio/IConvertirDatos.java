/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.literalura.servicio;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public interface IConvertirDatos {
    
    <T> T obtenerDatos(String json, Class<T> clase);
    
}
