package edu.telus.demo.proyecto.converter;

/**
 *
 * @author Mario Batres
 */
public interface Converter <T, D>{
    
    T convertir(D d);    
}
