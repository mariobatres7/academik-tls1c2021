package edu.telus.demo.proyecto.converter;

import edu.telus.demo.proyecto.dominio.Persona;
import edu.telus.demo.proyecto.dto.NameBasicsDTO;

/**
 *
 * @author Mario Batres
 */
public class PersonaDTOConverter implements Converter<Persona, NameBasicsDTO> {

    @Override
    public Persona convertir(NameBasicsDTO dto) {
        Persona persona = new Persona();
        persona.setCodigo(dto.getNconst());
        persona.setNombre(dto.getPrimaryName());

        persona.setAnyoNacimiento(this.convertirValor(dto.getBirthYear()));

        persona.setAnyoFallecimiento(this.convertirValor(dto.getDeathYear()));

        return persona;
    }

}
