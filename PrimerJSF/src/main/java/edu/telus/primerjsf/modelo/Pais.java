package edu.telus.primerjsf.modelo;

import java.math.BigDecimal;

/**
 *
 * @author Mario Batres
 */
public class Pais {

    private Integer id;

    private String nombre;
    
    private BigDecimal ranking;

    public Pais() {
    }

    public Pais(Integer id, String nombre, BigDecimal ranking) {
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

    public BigDecimal getRanking() {
        return ranking;
    }

    public void setRanking(BigDecimal ranking) {
        this.ranking = ranking;
    }
    
    

}
