package edu.telus.demo.proyecto.converter;

import edu.telus.demo.proyecto.dominio.Persona;
import edu.telus.demo.proyecto.dto.NameBasicsDTO;

/**
 *
 * @author Mario Batres
 */
public class PersonaDTOConverter implements Converter<Persona, NameBasicsDTO >{

    private String convertirAnyo(String year){
        if (year.equalsIgnoreCase("N")){
            return null;
        }
        
        return year;
    }
    
    @Override
    public Persona convertir(NameBasicsDTO dto) {
        Persona persona = new Persona();        
        persona.setCodigo(dto.getNconst());
        persona.setNombre(dto.getPrimaryName());
        
        persona.setAnyoNacimiento(this.convertirAnyo(dto.getBirthYear()));
        
        persona.setAnyoFallecimiento(this.convertirAnyo(dto.getDeathYear()));
        
        return persona;
    }

}
