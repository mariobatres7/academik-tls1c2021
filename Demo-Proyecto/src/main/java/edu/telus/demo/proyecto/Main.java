package edu.telus.demo.proyecto;

import com.opencsv.CSVParser;
import com.opencsv.bean.CsvToBeanBuilder;
import edu.telus.demo.proyecto.converter.PersonaDTOConverter;
import edu.telus.demo.proyecto.converter.ProfesionDTOConverter;
import edu.telus.demo.proyecto.dominio.Persona;
import edu.telus.demo.proyecto.dominio.Profesion;
import edu.telus.demo.proyecto.dto.NameBasicsDTO;
import edu.telus.demo.proyecto.dto.TitleBasicsDTO;
import edu.telus.demo.proyecto.repositorio.PersonaRepositorio;
import edu.telus.demo.proyecto.repositorio.ProfesionRepositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.io.*;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Mario Batres
 */
public class Main {

    public static class ArchivoControlador {

        private static final int MAX = 50;

        private int intLine = 0;

        private final StringBuilder stringBuilder;

        public ArchivoControlador() {
            this.stringBuilder = new StringBuilder();
        }

        public boolean esLineaValidaDeLectura() {
            return intLine <= MAX;
        }

        private void sumarLinea() {
            this.intLine++;
        }

        private void agregarLinea(String linea) {
            this.stringBuilder.append(linea).append("\n");
            this.sumarLinea();
        }

        public void exportarDatos(File path) throws IOException {

            try (FileOutputStream outputStream = new FileOutputStream(path)) {
                outputStream.write(this.stringBuilder.toString().getBytes());
            }
        }

        public void realizarLectura(File input) throws IOException {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {

                bufferedReader
                        .lines()
                        .takeWhile(p -> this.esLineaValidaDeLectura())
                        .forEach(this::agregarLinea);
            }
        }
    }

    public static class DTOParser {

        private InputStream getInputStream(InputStream in) throws IOException {

            PushbackInputStream testin = new PushbackInputStream(in);
            int ch = testin.read();
            if (ch != 0xEF) {
                testin.unread(ch);
            } else if ((ch = testin.read()) != 0xBB) {
                testin.unread(ch);
                testin.unread(0xef);
            } else if (testin.read() != 0xBF) {
                throw new IOException("Bad UTF-8 format file");
            } else {
            }
            return testin;
        }

        public <T> List<T> parse(Class<T> clazz, File input) throws IOException {

            try (FileInputStream bais = new FileInputStream(input)) {
                try (Reader reader = new InputStreamReader(this.getInputStream(bais), Charset.forName("UTF-8"))) {
                    return new CsvToBeanBuilder<T>(reader)
                            .withType(clazz)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withSeparator('\t')
                            .build()
                            .parse();
                }
            }

        }
    }

    public static void main2(String[] args) {

        try {
            File nameBasicsInput = new File("/home/shaka/workspace/Nabenik/Academik/1C2021-JavaWeb/imdb/name.basics.tsv");
            File nameBasicsOutput = new File("/home/shaka/workspace/Nabenik/Academik/1C2021-JavaWeb/imdb/name.output.tsv");

            ArchivoControlador nameBasicsArchivoControlador = new ArchivoControlador();
            nameBasicsArchivoControlador.realizarLectura(nameBasicsInput);
            nameBasicsArchivoControlador.exportarDatos(nameBasicsOutput);

            //----
            File titleBasicsInput = new File("/home/shaka/workspace/Nabenik/Academik/1C2021-JavaWeb/imdb/title.basics.tsv");
            File titleBasicsOutput = new File("/home/shaka/workspace/Nabenik/Academik/1C2021-JavaWeb/imdb/title.output.tsv");

            ArchivoControlador titleBasicsArchivoControlador = new ArchivoControlador();
            titleBasicsArchivoControlador.realizarLectura(titleBasicsInput);
            titleBasicsArchivoControlador.exportarDatos(titleBasicsOutput);

            //
            File titleAkasInput = new File("/home/shaka/workspace/Nabenik/Academik/1C2021-JavaWeb/imdb/title.akas.tsv");
            File titleAkasOutput = new File("/home/shaka/workspace/Nabenik/Academik/1C2021-JavaWeb/imdb/title.akas.output.tsv");

            ArchivoControlador titleAkasArchivoControlador = new ArchivoControlador();
            titleAkasArchivoControlador.realizarLectura(titleAkasInput);
            titleAkasArchivoControlador.exportarDatos(titleAkasOutput);

            File titleCrewInput = new File("/home/shaka/workspace/Nabenik/Academik/1C2021-JavaWeb/imdb/title.crew.tsv");
            File titleCrewOutput = new File("/home/shaka/workspace/Nabenik/Academik/1C2021-JavaWeb/imdb/title.crew.output.tsv");

            ArchivoControlador titleCrewArchivoControlador = new ArchivoControlador();
            titleCrewArchivoControlador.realizarLectura(titleCrewInput);
            titleCrewArchivoControlador.exportarDatos(titleCrewOutput);

            /*
            DTOParser dtoParser = new DTOParser();

            List<NameBasicsDTO> nameBasicsDTOList = dtoParser
                    .parse(NameBasicsDTO.class,nameBasicsOutput);

            nameBasicsDTOList.stream().findFirst().ifPresent(System.out::println);


            List<TitleBasicsDTO> titleBasicsDTOList = dtoParser
                    .parse(TitleBasicsDTO.class, titleBasicsOutput);

            titleBasicsDTOList.stream().findFirst().ifPresent(System.out::println);*/
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public static void main(String[] args) {

        EntityManager entityManager = Persistence.createEntityManagerFactory("DemoProyectoPU")
                .createEntityManager();

        try {
            File nameBasicsInput = new File("/home/shaka/workspace/Nabenik/Academik/1C2021-JavaWeb/imdb/name.basics.tsv");
            File nameBasicsOutput = new File("/home/shaka/workspace/Nabenik/Academik/1C2021-JavaWeb/imdb/name.output.tsv");

            ArchivoControlador nameBasicsArchivoControlador = new ArchivoControlador();
            nameBasicsArchivoControlador.realizarLectura(nameBasicsInput);
            nameBasicsArchivoControlador.exportarDatos(nameBasicsOutput);

            DTOParser dtoParser = new DTOParser();

            List<NameBasicsDTO> nameBasicsDTOList = dtoParser
                    .parse(NameBasicsDTO.class, nameBasicsOutput);

            entityManager.getTransaction().begin();

            PersonaRepositorio personaRepositorio = new PersonaRepositorio(entityManager);

            PersonaDTOConverter personaDTOConverter = new PersonaDTOConverter();

            ProfesionRepositorio profesionRepositorio = new ProfesionRepositorio(entityManager);

            ProfesionDTOConverter profesionDTOConverter = new ProfesionDTOConverter();

            List<Profesion> profesionList = profesionRepositorio.buscarProfesiones();

            nameBasicsDTOList.stream().forEach(dto -> {

                List<Profesion> profesionDtoList = profesionDTOConverter.convertir(dto);

                Set<Profesion> personaProfesionSet = new HashSet<>();

                profesionDtoList.stream().forEach(profesionNuevo -> {

                    profesionList
                            .stream()
                            .filter(p -> p.getNombre().equalsIgnoreCase(profesionNuevo.getNombre()))
                            .findFirst()
                            .ifPresentOrElse(p -> {
                                personaProfesionSet.add(p);
                            }, () -> {
                                
                                profesionRepositorio.crearOrActualizarProfesion(profesionNuevo);
                                profesionList.add(profesionNuevo);
                                
                                personaProfesionSet.add(profesionNuevo);
                            });                    
                });

                Persona persona = personaDTOConverter.convertir(dto);
                persona.setProfesionSet(personaProfesionSet);                
                personaRepositorio.crearOActualizarPersona(persona);

            });

            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());

            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
}
