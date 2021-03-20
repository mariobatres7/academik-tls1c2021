package edu.telus.segundoservlet.servicio;

import edu.telus.segundoservlet.modelo.Pais;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. Obtener el listado de paises.
 *
 * @author Mario Batres
 */
public class PaisServicio {

    public List<Pais> buscarPaises() {
  
        var pais1 = new Pais(1, "Francia", 11541291.92);
        var pais2 = new Pais(2, "Inglaterra", 2120.121234);
        var pais3 = new Pais(3, "España", 2119.15);
        var pais4 = new Pais(4, "Alemania", 2000.12);
        var pais5 = new Pais(5, "Italia", 1800.23);
        
        var paisList = new ArrayList<Pais>();

        paisList.add(pais1);
        paisList.add(pais2);
        paisList.add(pais3);
        paisList.add(pais4);
        paisList.add(pais5);
        
        return paisList;
    }
}
