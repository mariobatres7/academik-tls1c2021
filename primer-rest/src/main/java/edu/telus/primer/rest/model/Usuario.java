package edu.telus.primer.rest.model;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "usuario")
@Data
@EqualsAndHashCode(of = "usuarioId")
@ToString(of = "usuarioId")
@SelectBeforeUpdate
@DynamicInsert
@DynamicUpdate
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    @JsonbProperty("usuario-id")
    private Long usuarioId;

    @NotNull(message = "El campo nombre es requerido.")
    @NotEmpty(message = "Nombre no puede ser vacía")
    @Column(name = "nombre")
    private String nombre;

    @NotNull(message = "El campo contrañea es requerido.")
    @NotEmpty(message = "Contraseña no puede ser vacía")
    @Size(min = 8, message = "Tamaño de contraseña no válido.")
    @Column(name = "contraseña")
    private String contrasenya;

    @Size(min = 8, max = 20, message = "Tamaño de nombre de usuario no válido.")
    @Column(name = "usuario_nombre")
    @JsonbProperty("usuario-nombre")
    private String usuarioNombre;

    @Email(message = "No es un correo válido.")
    @Transient
    private String email;
    
    @JsonbTransient // Esto es para ignorarlo en el json 
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST)
    private List<UsuarioLog> usuarioLogList;

    public Usuario() {
        this.usuarioLogList = new ArrayList<>();
    }

}
