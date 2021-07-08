package DataBaseConector;

import Models.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private Connection Con; 
    private Statement Sentencia;
    private ResultSet Filas;
    
    public DAO(){
        ConexionMySql C = new ConexionMySql();
        Con = C.conectarMySQL();
    }
    
    public int insertarCategoria(Categoria C) throws SQLException{
        int filasAfectadas = 0;
        Sentencia = Con.createStatement();
        filasAfectadas = Sentencia.executeUpdate("INSERT INTO tblCategorias (Nombre, Descripcion, Imagen) VALUES ('"+C.getNombre()+"', '"+C.getDescripcion()+"', '"+C.getImagen()+"')");
        return filasAfectadas;
    }

    public int eliminarCategoria(Categoria C) throws SQLException{
        int filasAfectadas = 0;
        Sentencia = Con.createStatement();
        filasAfectadas = Sentencia.executeUpdate("DELETE FROM tblCategorias WHERE CategoriaId = "+C.getCategoriaId()+"");
        return filasAfectadas;
    }
    
    public int actualizarCategoria(Categoria C) throws SQLException{
        int filasAfectadas = 0;
        Sentencia = Con.createStatement();
        filasAfectadas = Sentencia.executeUpdate("UPDATE tblCategorias SET Nombre = '"+ C.getNombre()+"', Descripcion = '"+C.getDescripcion()+"', Imagen = '"+C.getImagen()+"' WHERE CategoriaId = "+C.getCategoriaId()+"");
        return filasAfectadas;
    }
    
    public List<Categoria> obtenerCategorias() throws SQLException{
        List<Categoria> listCategorias = new ArrayList<>();
        Sentencia = Con.createStatement();
        Filas = Sentencia.executeQuery("SELECT CategoriaId, Nombre, Descripcion, Imagen FROM tblCategorias");
        while(Filas.next()){
            Categoria C = new Categoria();
            C.setCategoriaId(Filas.getInt("CategoriaId"));
            C.setDescripcion(Filas.getString("Descripcion"));
            C.setNombre(Filas.getString("Nombre"));
            C.setImagen(Filas.getString("Imagen"));
            listCategorias.add(C);
        }
        return listCategorias;
    }
    
    public List<Libro> obtenerLibros() throws SQLException{
        Sentencia = Con.createStatement();
        Filas = Sentencia.executeQuery("SELECT L.LibroId, L.CategoriaId, C.Nombre as NombreCategoria FROM tblLibros L INNER JOIN tblCategorias C ON L.CategoriaId = C.CategoriaId");
        List<Libro> ListaLibros = new ArrayList<>();
        while(Filas.next()){
            Libro L = new Libro();
            L.setCategoriaId(Filas.getInt("CategoriaId"));
            L.setDescripcion(Filas.getString("Descripcion"));
            L.setISBN(Filas.getString("Isbn"));
            
            Categoria C = new Categoria();
            C.setCategoriaId(Filas.getInt("CategoriaId"));
            C.setNombre(Filas.getString("NombreCategoria"));
            
            Autor A = new Autor();
            
            
            L.setCategoria(C);
            
            
        }
        return ListaLibros;
    }
}
