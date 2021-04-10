package edu.telus.primerjsf.modelo;

import java.util.Date;
import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * lombok
 *
 * @author Mario Batres
 */
@Data
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "nombre"})
public class Jugador {

    private Integer id;

    private String nombre;

    private Date fechaNacimiento;

    public Jugador() {
        this.nombre = "";
    }

    public String getNombre() {
        return this.nombre.toUpperCase();
    }

    public void setFechaNacimiento(Date fechaNacimiento) {

        if (fechaNacimiento.getTime() > new Date().getTime()) {
            this.fechaNacimiento = null;
        } else {
            this.fechaNacimiento = fechaNacimiento;
        }

    }
}
