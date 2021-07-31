package edu.telus.demo.proyecto.converter;

import edu.telus.demo.proyecto.dominio.Titulo;
import edu.telus.demo.proyecto.dto.TitleBasicsDTO;
import java.util.Optional;

/**
 *
 * @author Mario Batres
 */
public class TituloDTOConverter implements Converter<Titulo, TitleBasicsDTO> {

    @Override
    public Titulo convertir(TitleBasicsDTO dto) {
               
        
        Titulo titulo = new Titulo();
        titulo.setCodigo(dto.getTconst());
        titulo.setNombre(dto.getPrimaryTitle());
        titulo.setNombreOriginal(dto.getOriginalTitle());
        
        /*
        if (dto.getIsAdult() != null) {
            
            int isAdult = Integer.valueOf(dto.getIsAdult());
            
            boolean paraAdultos = isAdult == 1;
                        
            titulo.setParaAdultos(paraAdultos);
            
        } else {
            
            titulo.setParaAdultos(false);
        } */
                
        Optional.ofNullable(dto.getIsAdult())
                .map(Integer::valueOf)
                .map(paraAdultos -> paraAdultos == 1)
                .ifPresentOrElse(titulo::setParaAdultos, () -> titulo.setParaAdultos(false));
        
        Optional.ofNullable(this.convertirValor(dto.getRuntimeMinutes()))
                .map(Integer::valueOf)
                .ifPresent(titulo::setTiempo);
        
        
        titulo.setAnyoFin(this.convertirValor(dto.getEndYear()));
        
        titulo.setAnyoInicio(this.convertirValor(dto.getStartYear()));
        
        return titulo;
    }
    
}
