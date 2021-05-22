package edu.telus.primerjpa.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Mario Batres
 */
@Entity
@Table(name = "equipo_financiero")
public class EquipoFinanciero implements Serializable {

    @Id
    @Column(name = "equipo_id")
    private Long equipoId;

    @Column(name = "capital_actual")
    private BigDecimal capitalActual;

    @Column(name = "ultimo_valor_fiscal")
    private BigDecimal ultimoValorFiscal;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "equipo_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Equipo equipo;
    
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public BigDecimal getCapitalActual() {
        return capitalActual;
    }

    public void setCapitalActual(BigDecimal capitalActual) {
        this.capitalActual = capitalActual;
    }

    public BigDecimal getUltimoValorFiscal() {
        return ultimoValorFiscal;
    }

    public void setUltimoValorFiscal(BigDecimal ultimoValorFiscal) {
        this.ultimoValorFiscal = ultimoValorFiscal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.equipoId);
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
        final EquipoFinanciero other = (EquipoFinanciero) obj;
        return Objects.equals(this.equipoId, other.equipoId);
    }

}
