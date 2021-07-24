package edu.telus.demo.proyecto.converter;

import edu.telus.demo.proyecto.dominio.Profesion;
import edu.telus.demo.proyecto.dto.NameBasicsDTO;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Mario Batres
 */
public class ProfesionDTOConverter implements Converter<List<Profesion>, NameBasicsDTO> {

    @Override
    public List<Profesion> convertir(NameBasicsDTO dto) {

        List<Profesion> profesionList = Stream.of(dto.getPrimaryProfession().split(","))
                .map(name -> {
                    Profesion profesion = new Profesion();
                    profesion.setNombre(name);

                    return profesion;
                }).collect(Collectors.toList());

        return profesionList;
    }
}
