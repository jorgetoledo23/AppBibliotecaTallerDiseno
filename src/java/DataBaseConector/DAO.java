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
    
    public int insertarLibro(Libro L) throws SQLException{
        int filasAfectadas = 0;
        Sentencia = Con.createStatement();
        filasAfectadas = Sentencia.executeUpdate("INSERT INTO tblLibros (Titulo, ISBN, Imagen, Autor, Descripcion, Precio, Stock, CategoriaId) VALUES ('"+L.getTitulo()+"', '"+L.getIsbn()+"', '"+L.getImagen()+"', '"+L.getAutor()+"', '"+L.getDescripcion()+"', '"+L.getPrecio()+"', '"+L.getStock()+"', '"+L.getCategoriaId()+"')");
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
    
    
    public Categoria obtenerCategoriaPorId(int CategoriaId) throws SQLException{
        Sentencia = Con.createStatement();
        Filas = Sentencia.executeQuery("SELECT CategoriaId, Nombre, Descripcion, Imagen FROM tblCategorias Where CategoriaId = "+CategoriaId+"");
        Categoria C = new Categoria();
        while(Filas.next()){
            
            C.setCategoriaId(Filas.getInt("CategoriaId"));
            C.setDescripcion(Filas.getString("Descripcion"));
            C.setNombre(Filas.getString("Nombre"));
            C.setImagen(Filas.getString("Imagen"));
        }
        return C;
    }
    
    
    
    public List<Libro> obtenerLibros() throws SQLException{
        Sentencia = Con.createStatement();
        Filas = Sentencia.executeQuery("SELECT L.Titulo, L.LibroId, L.CategoriaId, L.Autor, L.Precio, L.Stock, L.Descripcion, L.ISBN, L.Imagen, C.Nombre as NombreCategoria FROM tblLibros L INNER JOIN tblCategorias C ON L.CategoriaId = C.CategoriaId");
        List<Libro> ListaLibros = new ArrayList<>();
        while(Filas.next()){
            Libro L = new Libro();
            L.setCategoriaId(Filas.getInt("CategoriaId"));
            L.setTitulo(Filas.getString("Titulo"));
            L.setDescripcion(Filas.getString("Descripcion"));
            L.setIsbn(Filas.getString("Isbn"));
            L.setImagen(Filas.getString("Imagen"));
            L.setPrecio(Filas.getInt("Precio"));
            L.setStock(Filas.getInt("Stock"));
            L.setAutor(Filas.getString("Autor"));
            L.setLibroId(Filas.getInt("LibroId"));
            Categoria C = new Categoria();
            C.setCategoriaId(Filas.getInt("CategoriaId"));
            C.setNombre(Filas.getString("NombreCategoria"));
            L.setCategoria(C);
            ListaLibros.add(L);
        }
        return ListaLibros;
    }
    
    public Libro obtenerLibroById(String LibroId) throws SQLException{
        Sentencia = Con.createStatement();
        Filas = Sentencia.executeQuery("SELECT L.Titulo, L.LibroId, L.CategoriaId, L.Autor, L.Precio, L.Stock, L.Descripcion, L.ISBN, L.Imagen, C.Nombre as NombreCategoria FROM tblLibros L INNER JOIN tblCategorias C ON L.CategoriaId = C.CategoriaId WHERE L.LibroId = " + LibroId);
        Libro L = new Libro();
        while(Filas.next()){
            L.setCategoriaId(Filas.getInt("CategoriaId"));
            L.setTitulo(Filas.getString("Titulo"));
            L.setDescripcion(Filas.getString("Descripcion"));
            L.setIsbn(Filas.getString("Isbn"));
            L.setImagen(Filas.getString("Imagen"));
            L.setPrecio(Filas.getInt("Precio"));
            L.setStock(Filas.getInt("Stock"));
            L.setAutor(Filas.getString("Autor"));
            L.setLibroId(Filas.getInt("LibroId"));
            Categoria C = new Categoria();
            C.setCategoriaId(Filas.getInt("CategoriaId"));
            C.setNombre(Filas.getString("NombreCategoria"));
            L.setCategoria(C);
        }
        return L;
    }
    
    
    public List<Libro> obtenerLibrosByCat(String CategoriaId) throws SQLException{
        Sentencia = Con.createStatement();
        Filas = Sentencia.executeQuery("SELECT L.Titulo, L.LibroId, L.CategoriaId, L.Autor, L.Precio, L.Stock, L.Descripcion, L.ISBN, L.Imagen, C.Nombre as NombreCategoria FROM tblLibros L INNER JOIN tblCategorias C ON L.CategoriaId = C.CategoriaId WHERE L.CategoriaId = " + CategoriaId );
        List<Libro> ListaLibros = new ArrayList<>();
        while(Filas.next()){
            Libro L = new Libro();
            L.setCategoriaId(Filas.getInt("CategoriaId"));
            L.setTitulo(Filas.getString("Titulo"));
            L.setDescripcion(Filas.getString("Descripcion"));
            L.setIsbn(Filas.getString("Isbn"));
            L.setImagen(Filas.getString("Imagen"));
            L.setPrecio(Filas.getInt("Precio"));
            L.setStock(Filas.getInt("Stock"));
            L.setAutor(Filas.getString("Autor"));
            L.setLibroId(Filas.getInt("LibroId"));
            Categoria C = new Categoria();
            C.setCategoriaId(Filas.getInt("CategoriaId"));
            C.setNombre(Filas.getString("NombreCategoria"));
            L.setCategoria(C);
            ListaLibros.add(L);
        }
        return ListaLibros;
    }
}
