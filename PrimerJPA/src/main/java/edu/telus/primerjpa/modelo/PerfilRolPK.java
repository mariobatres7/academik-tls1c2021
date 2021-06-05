package edu.telus.primerjpa.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Mario Batres
 */
@Embeddable
public class PerfilRolPK implements Serializable {

    @Column(name = "perfil_id")
    private Long perfilId;

    @Column(name = "rol_id")
    private Long rolId;

    public Long getPerfilId() {
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
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.perfilId);
        hash = 59 * hash + Objects.hashCode(this.rolId);
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
        final PerfilRolPK other = (PerfilRolPK) obj;
        if (!Objects.equals(this.perfilId, other.perfilId)) {
            return false;
        }
        return Objects.equals(this.rolId, other.rolId);
    }

    @Override
    public String toString() {
        return "PerfilRolPK{" + "perfilId=" + perfilId + ", rolId=" + rolId + '}';
    }

}
