
package paquete02;

import java.io.Serializable;

public class Propietario implements Serializable{
    private String nombres;
    private String apellidos;
    private String identificacion;
    
    // Constructor
    public Propietario(String nom, String ap, String dni){
        nombres = nom;
        apellidos= ap;
        identificacion = dni;
    }
    
    // Los establecer de los atributos
    public void establecerNombres(String pro){
        nombres = pro;
    }
    public void establecerApellidos(String pro){
        apellidos = pro;
    }
    public void establecerIdentificacion(String pro){
        identificacion = pro;
    }
    
    // Los obtener de los atributos
    public String obtenerNombres(){
        return nombres;
    }
    public String obtenerApellidos(){
        return apellidos;
    }
    public String obtenerIdentificacion(){
        return identificacion;
    }
    
    // Metodo toString
    @Override
    public String toString(){
        String pro = String.format("PROPIETARIO\nNombre: %s\nApellido: %s\n"
                + "Identificacion: %s\n"
                ,obtenerNombres()
                ,obtenerApellidos()
                ,obtenerIdentificacion()
                );
        return pro;
    }
}
