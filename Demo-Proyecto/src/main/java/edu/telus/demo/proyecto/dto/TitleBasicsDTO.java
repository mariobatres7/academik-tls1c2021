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
public class TitleBasicsDTO {

    @CsvBindByName
    private String tconst;
    
    @CsvBindByName
    private String titleType;
    
    @CsvBindByName
    private String primaryTitle;
    
    @CsvBindByName
    private String originalTitle;
    
    @CsvBindByName
    private String isAdult;
    
    @CsvBindByName
    private String startYear;
    
    @CsvBindByName
    private String endYear;
    
    @CsvBindByName
    private String runtimeMinutes;
    
    @CsvBindByName
    private String genres;
}
