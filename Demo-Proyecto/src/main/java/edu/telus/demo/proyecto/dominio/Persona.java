package edu.telus.demo.proyecto.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Set;
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
@Table(name = "persona")
@Data
@EqualsAndHashCode(of = "personaId", callSuper = false)
@ToString(of = "personaId")
@DynamicInsert
@SelectBeforeUpdate
@DynamicUpdate
public class Persona extends Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id")
    private Long personaId;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "anyo_nacimiento")
    private String anyoNacimiento;

    @Column(name = "anyo_fallecimiento")
    private String anyoFallecimiento;

    @ManyToMany
    @JoinTable(
            name = "persona_profesion",
            joinColumns = @JoinColumn(name = "persona_id", referencedColumnName = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "profesion_id", referencedColumnName = "profesion_id")
    )
    private Set<Profesion> profesionSet;
    
    @OneToMany(mappedBy = "persona")
    private List<PersonaTitulo> personaTituloList;
}
