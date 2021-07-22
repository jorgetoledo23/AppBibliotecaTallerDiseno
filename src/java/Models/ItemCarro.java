package Models;

public class ItemCarro {
    
    private int LibroId;
    
    private int Cantidad;
    
    private Libro Libro;

    public int getLibroId() {
        return LibroId;
    }

    public void setLibroId(int LibroId) {
        this.LibroId = LibroId;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Libro getLibro() {
        return Libro;
    }

    public void setLibro(Libro Libro) {
        this.Libro = Libro;
    }
    
}
