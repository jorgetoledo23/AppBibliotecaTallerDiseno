package Controller;

import DataBaseConector.DAO;
import Models.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControllerCategoria", urlPatterns = {"/ControllerCategoria"})
public class ControllerCategoria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Cargar Todas las Categorias
        DAO D = new DAO();
        try {
            getServletContext().setAttribute("ListadoCategorias", D.obtenerCategorias());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        response.sendRedirect("CategoriaIndex.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Aqui llegamos desde el Form
        Categoria C = new Categoria();
        C.setNombre(request.getParameter("categoriaName"));
        C.setDescripcion(request.getParameter("categoriaDescripcion"));
        
        DAO D = new DAO();
        
        switch (request.getParameter("Accion")) {
            case "Guardar Categoria":
        {
            try {
                //Guardar Nueva Categoria
                if (D.insertarCategoria(C) == 1){
                    response.sendRedirect("ControllerCategoria");
                }else{
                    request.setAttribute("msgError", "Error al Insertar! Intente de nuevo");
                    request.getRequestDispatcher("CategoriaIndex.jsp").forward(request, response);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
                
                
                
                break;
        }
        

    }

}
