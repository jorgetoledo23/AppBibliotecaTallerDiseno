package Controller;

import DataBaseConector.DAO;
import Models.Categoria;
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
import java.util.HashSet;
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
@WebServlet(name = "ControllerCategoria", urlPatterns = {"/ControllerCategoria"})
public class ControllerCategoria extends HttpServlet {
    
    



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            
        DAO D = new DAO();
        if(request.getParameter("opcion") == null){
            //Cargar Todas las Categorias
            getServletContext().setAttribute("ListadoCategorias", D.obtenerCategorias());
            response.sendRedirect("CategoriaIndex.jsp");
        }
        if(request.getParameter("opcion") != null){
            int CatId = Integer.parseInt(request.getParameter("catId"));
            Categoria C = D.obtenerCategoriaPorId(CatId);
            switch (request.getParameter("opcion")) {
                case "edit":
                    //Aqui Editamos la Categoria
                    request.setAttribute("Categoria", C);
                    request.getRequestDispatcher("CategoriaEdit.jsp").forward(request, response);
                    break;
                case "delete":
                    D.eliminarCategoria(C);
                    response.sendRedirect("ControllerCategoria");
                    break;
            }
        }
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
        




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Aqui llegamos desde el Form
        Categoria C = new Categoria();
        C.setNombre(request.getParameter("categoriaName"));
        C.setDescripcion(request.getParameter("categoriaDescripcion"));
        Part x = request.getPart("CategoriaImagen");
        if (x.getSubmittedFileName()!= "") {
            C.setImagen(getImagen(request.getPart("CategoriaImagen"), request));
        }else{
            C.setImagen("no-disponible.png");
        }
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
            case "Guardar Cambios":
                //Editar Categoria
                C.setCategoriaId(Integer.parseInt(request.getParameter("categoriaId")));
        {
            try {
                if (D.actualizarCategoria(C) == 1) {
                    //UPDATE OK
                    response.sendRedirect("ControllerCategoria");
                }else{
                    request.setAttribute("msgError", "Error al Actualizar! Intente de nuevo");
                    request.getRequestDispatcher("CategoriaEdit.jsp").forward(request, response);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
                break;
        }
        

    }
    
    
    private String getImagen(Part Imagen, HttpServletRequest request) throws IOException{
    
        String foto = "foto";
        int estado = 1;
        //Ubicamos la ruta en donde se almacenará la imagen
        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + "img\\";
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
