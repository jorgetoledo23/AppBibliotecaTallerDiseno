
package Controller;

import DataBaseConector.DAO;
import Models.ItemCarro;
import Models.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ControllerCarroCompras", urlPatterns = {"/ControllerCarroCompras"})
public class ControllerCarroCompras extends HttpServlet {

  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<ItemCarro> CarroCompra;
        if (request.getSession().getAttribute("CarroCompra") == null) {
            CarroCompra = new ArrayList<>();
            request.getSession().setAttribute("CarroCompra", CarroCompra);
        }else{
            CarroCompra = (List<ItemCarro>) request.getSession().getAttribute("CarroCompra");
        }
        
        String LibroId = request.getParameter("LibroId");
        
        DAO D = new DAO();
        try {
            Libro L = D.obtenerLibroById(LibroId);
        
        
        Boolean Existe = false;
        ItemCarro Item = null;
        for (ItemCarro item : CarroCompra) {
            if (L.getLibroId() == item.getLibroId()) {
                Existe = true;
                Item = item;
            }
        }
        
        if (!Existe) {
            Item = new ItemCarro();
            Item.setCantidad(1);
            Item.setLibro(L);
            Item.setLibroId(L.getLibroId());
            CarroCompra.add(Item);
        }else{
            int cantidadActual = Item.getCantidad();
            Item.setCantidad(cantidadActual+1);
        }
        
        response.sendRedirect("CarroCompra.jsp");
        
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }



}
