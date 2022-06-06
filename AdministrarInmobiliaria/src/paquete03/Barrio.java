
package paquete03;

import java.io.Serializable;


public class Barrio implements Serializable{
    private String nombre_barrio;
    private String referencia;
    
    // Constructor
    public Barrio(String nomBa, String refe){
        nombre_barrio = nomBa;
        referencia = refe;
    }
    
    //Los establecer de los atributos
    public void establecerNombre_barrio(String ba){
        nombre_barrio = ba;
    }
    public void establecerReferencia(String ba){
        referencia = ba;
    }
    
    //Los obtener de los atributos
    public String obtenerNombre_barrio(){
        return nombre_barrio;
    }
    public String obtenerReferencia(){
        return referencia;
    }
    
    //Metodo toString
    @Override
    public String toString() {
        String ba = String.format("BARRIO\nNombre del barrio: %s\n"
                + "Referencia: %s\n"
                ,obtenerNombre_barrio()
                ,obtenerReferencia()
        );
        return ba;
    }
}
