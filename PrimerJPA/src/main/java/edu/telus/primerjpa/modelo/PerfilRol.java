package edu.telus.primerjpa.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Mario Batres
 */
@Entity
@Table(name = "perfil_rol")
public class PerfilRol implements Serializable {

    @EmbeddedId
    private PerfilRolPK pk;

    /*@Id
    @Column(name = "perfil_id")
    private Long perfilId;

    @Id
    @Column(name = "rol_id")
    private Long rolId;*/
    
    @Column(name = "asignado_el")
    private LocalDateTime asignadoEl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil_id", referencedColumnName = "perfil_id", insertable = false, updatable = false)
    private Perfil perfil;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id", insertable = false, updatable = false)
    private Rol rol;

    /*  public Long getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Long perfilId) {
        this.perfilId = perfilId;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }*/
    public PerfilRolPK getPk() {
        return pk;
    }

    public void setPk(PerfilRolPK pk) {
        this.pk = pk;
    }

    public LocalDateTime getAsignadoEl() {
        return asignadoEl;
    }

    public void setAsignadoEl(LocalDateTime asignadoEl) {
        this.asignadoEl = asignadoEl;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.pk);
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
        final PerfilRol other = (PerfilRol) obj;
        return Objects.equals(this.pk, other.pk);
    }

    @Override
    public String toString() {
        return "PerfilRol{" + "pk=" + pk + '}';
    }
}
