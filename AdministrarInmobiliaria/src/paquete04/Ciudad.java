
package paquete04;

import java.io.Serializable;

public class Ciudad implements Serializable{
    private String nombre_ciudad;
    private String nombre_provincia;
    
    
    public Ciudad(String nomc, String nomp){
        nombre_ciudad = nomc;
        nombre_provincia = nomp;
    }
    
    // Los establecer de los atributos
    public void establecerNombre_ciudad(String ci){
        nombre_ciudad = ci;
    }
    public void establecerNombre_provincia(String ci){
        nombre_provincia = ci;
    }
    
    // Los obtener de los atributos
    public String obtenerNombre_ciudad(){
        return nombre_ciudad;
    }
    public String obtenerNombre_provincia(){
        return nombre_provincia;
    }
    
    // Metodo toString
    @Override
    public String toString() {
        String ci = String.format("CIUDAD\nNombre de la ciudad: %s\n"
                + "Nombre de la provincia: %s\n"
                ,obtenerNombre_ciudad()
                ,obtenerNombre_provincia()
        );
        return ci;
    }
    
}
