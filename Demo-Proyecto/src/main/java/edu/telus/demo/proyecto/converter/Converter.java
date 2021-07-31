package edu.telus.demo.proyecto.converter;

/**
 *
 * @author Mario Batres
 */
public interface Converter<T, D> {

    T convertir(D d);

    default String convertirValor(String valor) {
        
        if (valor == null || valor.equalsIgnoreCase("N")) {
            return null;
        }

        return valor;
    }

}
