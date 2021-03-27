package edu.telus.primerjsf.controlador;

import edu.telus.primerjsf.modelo.Pais;
import edu.telus.primerjsf.servicio.PaisServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * ManagedBean a la clase que se conecta con la pagina JSF 
 * @author Mario Batres
 */
@Named
@ViewScoped
public class PaisControlador implements Serializable {

    @Inject
    private PaisServicio paisServicio;

    private List<Pais> paisList;

    @PostConstruct
    public void init() {
        this.paisList = this.paisServicio.buscarPaises();
    }

    public List<Pais> getPaisList() {
        return paisList;
    }
}
