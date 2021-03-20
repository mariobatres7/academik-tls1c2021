package edu.telus.segundoservlet.modelo;

/**
 *
 * @author Mario Batres
 */
public class Jugador {
    
    private Integer id;
    
    private String nombre;
    
    private String apellido;
    
    private Integer edad;
    
    private Pais paisNacimiento;
    
    private Liga ligaActual;

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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Pais getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(Pais paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public Liga getLigaActual() {
        return ligaActual;
    }

    public void setLigaActual(Liga ligaActual) {
        this.ligaActual = ligaActual;
    }
    
    
}
