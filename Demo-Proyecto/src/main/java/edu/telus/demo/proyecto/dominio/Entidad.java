package edu.telus.demo.proyecto.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mario Batres
 */
@Getter
@Setter
@MappedSuperclass
public class Entidad implements Serializable {

    @Column(name = "creado_el")
    private LocalDateTime creadoEl;

    @Column(name = "modificado_el")
    private LocalDateTime modificadoEl;
    
 
    @PrePersist
    public void ejecutarAntesDePersistir(){
        this.creadoEl = LocalDateTime.now();
    }
    
    @PreUpdate
    public void ejecutarAntesDeActualizar(){
        this.modificadoEl = LocalDateTime.now();
    }
}
