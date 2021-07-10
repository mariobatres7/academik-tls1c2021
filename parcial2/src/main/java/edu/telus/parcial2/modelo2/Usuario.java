package edu.telus.parcial2.modelo2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Mario Batres
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="usuario_id")
    private Long usuarioId;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="nombre_usuario")
    private String nombreUsuario;

    @Column(name="clave")
    private String clave;

    @ManyToMany
    @JoinTable(name="usuario_perfil",
            joinColumns = @JoinColumn(name="usuario_id", referencedColumnName = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name="perfil_id", referencedColumnName = "perfil_id")
    )
    private Set<Perfil> perfilSet;
}
