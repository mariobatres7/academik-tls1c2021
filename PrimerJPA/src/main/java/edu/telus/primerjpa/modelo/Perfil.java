package edu.telus.primerjpa.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Mario Batres
 */
@Entity
@Table(name = "perfil")
public class Perfil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perfil_id")
    private Long perfilId;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToMany(mappedBy = "perfilSet")
    private Set<Usuario> usuarioSet;

    @OneToMany(mappedBy = "perfil")
    private Set<PerfilRol> perfilRolSet;

    public Perfil() {
    }

    public Perfil(Long perfilId) {
        this.perfilId = perfilId;
    }

    public Long getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Long perfilId) {
        this.perfilId = perfilId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Usuario> getUsuarioSet() {
        return usuarioSet;
    }

    public void setUsuarioSet(Set<Usuario> usuarioSet) {
        this.usuarioSet = usuarioSet;
    }

    public Set<PerfilRol> getPerfilRolSet() {
        return perfilRolSet;
    }

    public void setPerfilRolSet(Set<PerfilRol> perfilRolSet) {
        this.perfilRolSet = perfilRolSet;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.perfilId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Perfil other = (Perfil) obj;
        return Objects.equals(this.perfilId, other.perfilId);
    }

    @Override
    public String toString() {
        return "Perfil{" + "perfilId=" + perfilId + '}';
    }

}
