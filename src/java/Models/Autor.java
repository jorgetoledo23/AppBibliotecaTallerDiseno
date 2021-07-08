/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Profe
 */
class Autor {
    
    private int AutorId;
    private String Nombre;
    private String Nacionalidad;

    public Autor(){}
    
    public int getAutorId() {
        return AutorId;
    }

    public void setAutorId(int AutorId) {
        this.AutorId = AutorId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }
    
    
    
}
