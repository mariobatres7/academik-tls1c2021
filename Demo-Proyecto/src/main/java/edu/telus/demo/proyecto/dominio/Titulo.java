package edu.telus.demo.proyecto.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

/**
 *
 * @author Mario Batres
 */
@Entity
@Table(name = "titulo")
@Data
@EqualsAndHashCode(of = "tituloId", callSuper = false)
@ToString(of = "tituloId")
@DynamicInsert
@SelectBeforeUpdate
@DynamicUpdate
public class Titulo extends Entidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "titulo_id")
    private Long tituloId;
    
    @Column(name = "codigo")
    private String codigo;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "nombre_original")
    private String nombreOriginal;
    
    @Column(name = "para_adultos")
    private boolean paraAdultos;
    
    @Column(name = "anyo_inicio")
    private String anyoInicio;
    
    @Column(name = "anyo_fin")
    private String anyoFin;
    
    @Column(name = "tiempo")
    private Integer tiempo;
    
    @OneToMany(mappedBy = "titulo")
    private List<PersonaTitulo> personaTituloList;
    
}
