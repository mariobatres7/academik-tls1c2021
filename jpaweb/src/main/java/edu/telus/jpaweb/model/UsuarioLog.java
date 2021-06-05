package edu.telus.jpaweb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author Mario Batres
 */
@Entity
@Table(name = "usuario_log")
@Data
@EqualsAndHashCode(of = "usuarioLogId")
@ToString(of = "usuarioLogId")
public class UsuarioLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_log_id")
    private Long usuarioLogId;

    @Column(name = "registrado_el")
    private LocalDateTime registradoEl;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;
}
