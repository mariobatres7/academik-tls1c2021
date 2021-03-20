package edu.academik.telus.jw1c2021.primerservlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mario Batres
 */
@WebServlet(name = "ImageServlet", urlPatterns = {"/imagen.do"})
public class ImagenServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String img = request.getParameter("img");
        // String ext = request.getParameter("ext");

        if (img != null /*&& ext != null*/) {
            // try with resources
            //                                                 "C:\\tmp\\imagenes\\" + img + ".png"

            String pathFileStr = "/tmp/imagenes/" + img;

            try (InputStream inputStream = new FileInputStream(pathFileStr)) {

                byte[] bytes = inputStream.readAllBytes();

                try (OutputStream outputStream = response.getOutputStream()) {

                    Path path = new File(pathFileStr).toPath();
                    String mimeType = Files.probeContentType(path);
                    System.out.println(mimeType);
                    response.setContentType(mimeType);

                    /*
                    switch (ext) {
                        case "png":
                            response.setContentType("image/png");
                            break;

                        case "jpg":
                            response.setContentType("image/jpeg");
                            break;

                        case "zip":
                            response.setContentType("application/zip");
                            break;

                        case "tar":
                            response.setContentType("application/gzip");
                            break;

                        case "rar":
                            response.setContentType("application/vnd.rar");
                            break;
                    }
                     */
                    outputStream.write(bytes);
                }
            }
        }
    }
}
