package edu.telus.segundoservlet.modelo;

/**
 *
 * @author Mario Batres
 */
public class Pais {

    private Integer id;

    private String nombre;
    
    private double ranking;

    public Pais() {
    }

    public Pais(Integer id, String nombre, double ranking) {
        this.id = id;
        this.nombre = nombre;
        this.ranking = ranking;
    }    

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

    public double getRanking() {
        return ranking;
    }

    public void setRanking(double ranking) {
        this.ranking = ranking;
    }
    
    

}
