
package Controller;

import DataBaseConector.DAO;
import Models.Libro;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet(name = "ControllerLibro", urlPatterns = {"/ControllerLibro"})
public class ControllerLibro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            //Carguemos todos los Libros en un Listado desde la BD
            DAO D = new DAO();
            getServletContext().setAttribute("ListadoLibros", D.obtenerLibros());
            //Y se lo pasamos como parametro al Index.jsp
            
            
            response.sendRedirect("LibroIndex.jsp");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Libro L = new Libro();
        
        L.setTitulo(request.getParameter("libroName"));
        L.setIsbn(request.getParameter("libroISBN"));
        L.setAutor(request.getParameter("libroAutor"));
        L.setPrecio(Integer.parseInt(request.getParameter("libroPrecio")));
        L.setStock(Integer.parseInt(request.getParameter("libroStock")));
        
        Part x = request.getPart("LibroImagen");
        if (!"".equals(x.getSubmittedFileName())) {
            L.setImagen(getImagen(request.getPart("LibroImagen"), request));
        }else{
            L.setImagen("no-disponible.png");
        }
        L.setDescripcion(request.getParameter("libroDescripcion"));
        L.setCategoriaId(Integer.parseInt(request.getParameter("CategoriaId")));
        
        String Accion = request.getParameter("Accion");
        
        DAO D= new DAO();
        
        
        switch (Accion) {
            case "Guardar Libro":
        {
            try {
                //TODO: GUARDAR LIBRO
                if (D.insertarLibro(L) == 1) {
                    response.sendRedirect("ControllerLibro");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
                
                
                break;
                
            case "Guardar Cambios":
                //TODO:ACTUALIZAR LIBRO
                break;
                
            case "Eliminar":
                //TODO: ELIMINAR LIBRO
                break;
                
                
            default:
                throw new AssertionError();
        }        
    }
    
    private String getImagen(Part Imagen, HttpServletRequest request) throws IOException{
    
        String foto = "foto";
        int estado = 1;
        //Ubicamos la ruta en donde se almacenará la imagen
        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + "img" + File.separator + "imgLibros" + File.separator;
        //Declaracion de Stream para subir archivo
        OutputStream out = null;
        InputStream filecontent = null;
        //Configuracion del nombre del archivo

        String format = "";
        DateFormat hourdateFormat = new SimpleDateFormat("HHmmssddMMyyyy");//img/x12073017062021.jgp
        String fecha = hourdateFormat.format(new Date());
        //Se Valida la extencion
        String nombreArchivo = Imagen.getSubmittedFileName();
        if (nombreArchivo.endsWith(".png") || nombreArchivo.endsWith(".PNG")) {
            format = ".png";
        } else if (nombreArchivo.endsWith(".jpg") || nombreArchivo.endsWith(".JPG")) {
            format = ".jpg";
        } else if (nombreArchivo.endsWith(".jpeg") || nombreArchivo.endsWith(".JPEG")) {
            format = ".jpeg";
        }
        String file_photo = foto + "_" + fecha + format;
        try {
            out = new FileOutputStream(new File(savePath.replace("\\build", "") + File.separator + file_photo));
            filecontent = Imagen.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
        }
        return file_photo;
    
    }


}
