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
public class TitleCrewDTO {

    @CsvBindByName
    private String tconst;

    @CsvBindByName
    private String directors;

    @CsvBindByName
    private String writers;

    private String[] toArray(String valor) {
        if (valor.equalsIgnoreCase("N")) {
            return null;
        }

        return valor.split(",");
    }

    public String[] directorsToArray() {
        return this.toArray(this.directors);
    }

    public String[] writersToArray() {
        return this.toArray(this.writers);
    }

}
