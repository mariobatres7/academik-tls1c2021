package edu.telus.primerjpa.modelo;

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
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Mario Batres
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "contraseña")
    private String contrasenya;

    @Column(name = "usuario_nombre")
    private String usuarioNombre;
    
    @ManyToMany()
    @JoinTable(
            name = "usuario_perfil",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id", referencedColumnName = "perfil_id")
    )
    private Set<Perfil> perfilSet;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public Set<Perfil> getPerfilSet() {
        return perfilSet;
    }

    public void setPerfilSet(Set<Perfil> perfilSet) {
        this.perfilSet = perfilSet;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.usuarioId);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.usuarioId, other.usuarioId);
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuarioId=" + usuarioId + '}';
    }
    
    
    
}
