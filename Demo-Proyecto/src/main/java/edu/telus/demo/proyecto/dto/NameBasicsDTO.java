package edu.telus.demo.proyecto.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Mario Batres
 */
@Getter
@Setter
@ToString
public class NameBasicsDTO {
        
    @CsvBindByName
    private String nconst;
    
    @CsvBindByName
    private String primaryName;
    
    @CsvBindByName
    private String birthYear;
    
    @CsvBindByName
    private String deathYear;
    
    @CsvBindByName
    private String primaryProfession;
    
    @CsvBindByName
    private String knownForTitles;
    
}
