package Models;

public class Libro {
    
    private int LibroId;
    private String Titulo;
    private String ISBN;
    private String Imagen;
    private String Autor;
    private String Descripcion;
    private int Precio;
    private int Stock;
    private int enOferta;
    private int PrecioOferta;
    private int CategoriaId;
    private Categoria Categoria;

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getEnOferta() {
        return enOferta;
    }

    public void setEnOferta(int enOferta) {
        this.enOferta = enOferta;
    }

    public int getPrecioOferta() {
        return PrecioOferta;
    }

    public void setPrecioOferta(int PrecioOferta) {
        this.PrecioOferta = PrecioOferta;
    }

    public int getCategoriaId() {
        return CategoriaId;
    }

    public void setCategoriaId(int CategoriaId) {
        this.CategoriaId = CategoriaId;
    }

    public Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Categoria Categoria) {
        this.Categoria = Categoria;
    }
    
    public Libro(){
    }

    public int getLibroId() {
        return LibroId;
    }

    public void setLibroId(int libroId) {
        this.LibroId = libroId;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    
}
