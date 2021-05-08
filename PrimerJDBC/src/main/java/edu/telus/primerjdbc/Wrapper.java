package edu.telus.primerjdbc;

import java.sql.Timestamp;

/**
 *
 * @author Mario Batres
 */
public class Wrapper {

    private Integer id;

    private String nombre;

    private String apellido;

    private Timestamp creadoElTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Timestamp getCreadoElTime() {
        return creadoElTime;
    }

    public void setCreadoElTime(Timestamp creadoElTime) {
        this.creadoElTime = creadoElTime;
    }

    @Override
    public String toString() {
        return "Wrapper{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", creadoElTime=" + creadoElTime + '}';
    }

}
