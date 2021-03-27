package edu.telus.primerjsf.servicio;

import edu.telus.primerjsf.modelo.Pais;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;

/**
 * 1. Obtener el listado de paises.
 *
 * @author Mario Batres
 */
@RequestScoped
public class PaisServicio implements Serializable {

    public static List<Pais> paisDatasource = new ArrayList<>();

    public List<Pais> buscarPaises() {

        var pais1 = new Pais(1, "Francia", BigDecimal.valueOf(11541291.92));
        var pais2 = new Pais(2, "Inglaterra", BigDecimal.valueOf(2120.121234));
        var pais3 = new Pais(3, "España", BigDecimal.valueOf(2119.15));
        var pais4 = new Pais(4, "Alemania", BigDecimal.valueOf(2000.12));
        var pais5 = new Pais(5, "Italia", BigDecimal.valueOf(1800.23));

        paisDatasource.add(pais1);
        paisDatasource.add(pais2);
        paisDatasource.add(pais3);
        paisDatasource.add(pais4);
        paisDatasource.add(pais5);

        return paisDatasource;
    }

    public void agregarPais(Pais pais) {
        pais.setId(paisDatasource.size() + 1);
        paisDatasource.add(pais);
    }

}
