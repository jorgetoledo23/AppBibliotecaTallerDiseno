
package Controller;

import DataBaseConector.DAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ControllerInicio", urlPatterns = {"/ControllerInicio"})
public class ControllerInicio extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO D = new DAO();
        try {
            getServletContext().setAttribute("ListadoCategorias", D.obtenerCategorias());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        request.setAttribute("msgError", "Error al Insertar");
        //#1
        response.sendRedirect("LibroIndex.jsp");
        //#2
        //request.getRequestDispatcher("LibroIndex.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }



}
