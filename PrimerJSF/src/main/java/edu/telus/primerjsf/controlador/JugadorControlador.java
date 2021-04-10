package edu.telus.primerjsf.controlador;

import edu.telus.primerjsf.modelo.Jugador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Getter;

/**
 *
 * @author Mario Batres
 */
@Named
@ViewScoped
public class JugadorControlador implements Serializable {

    @Getter
    private Jugador jugador;

    @Getter
    private List<Jugador> jugadorList;

    @PostConstruct
    public void init() {
        this.jugador = new Jugador();
        this.jugadorList = new ArrayList<>();
    }

    public void agregar() {
        
        jugador.setId(this.jugadorList.size() + 1);
        
        this.jugadorList.add(jugador);
        
        this.jugador = new Jugador();        

    }

}
