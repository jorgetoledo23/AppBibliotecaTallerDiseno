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
        filasAfectadas = Sentencia.executeUpdate("INSERT INTO tblCategorias (Nombre, Descripcion) VALUES ('"+C.getNombre()+"', '"+C.getDescripcion()+"')");
        return filasAfectadas;
    }
    
    public List<Categoria> obtenerCategorias() throws SQLException{
        List<Categoria> listCategorias = new ArrayList<>();
        Sentencia = Con.createStatement();
        Filas = Sentencia.executeQuery("SELECT CategoriaId, Nombre, Descripcion FROM tblCategorias");
        while(Filas.next()){
            Categoria C = new Categoria();
            C.setCategoriaId(Filas.getInt("CategoriaId"));
            C.setDescripcion(Filas.getString("Descripcion"));
            C.setNombre(Filas.getString("Nombre"));
            listCategorias.add(C);
        }
        return listCategorias;
    }
    
}
