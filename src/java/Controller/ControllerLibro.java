
package Controller;

import Models.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ControllerLibro", urlPatterns = {"/ControllerLibro"})
public class ControllerLibro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Carguemos todos los Libros en un Listado desde la BD
        //Y se lo pasamos como parametro al Index.jsp
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Libro L = new Libro();
        
        L.setTitulo(request.getParameter("libroName"));
        L.setISBN(request.getParameter("libroISBN"));
        
        String Accion = request.getParameter("Accion");
        
        switch (Accion) {
            case "Guardar Libro":
                //TODO: GUARDAR LIBRO
                
                
                
                
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


}
