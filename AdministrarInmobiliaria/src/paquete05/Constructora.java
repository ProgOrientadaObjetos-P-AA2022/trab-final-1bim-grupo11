
package paquete05;

import java.io.Serializable;

public class Constructora implements Serializable{
    private String nombre_constructora;
    private String id_de_la_empresa;
    
    //Constructor
    public Constructora(String nomC, String id){
        nombre_constructora = nomC;
        id_de_la_empresa = id;
    }
    
    //Los establecer de los atributos
    public void establecerNombre_constructora(String co){
        nombre_constructora = co;
    }
    public void establecerId_de_la_empresa(String co){
        id_de_la_empresa = co;
    }
    
    //Los obtener de los atributos
    public String obtenerNombre_constructora(){
        return nombre_constructora;
    }
    public String obtenerId_de_la_empresa(){
        return id_de_la_empresa;
    }
    
    //Metodo toString
    @Override
    public String toString() {
        String co = String.format("CONSTRUCTORA\nNombre de la constructora: %s\n"
                + "Identificacion de la empresa: %s\n"
                ,obtenerNombre_constructora()
                ,obtenerId_de_la_empresa()
        );
        return co;
    }
}
