
package paquete04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscrituraCiudad {

    private String noArchivo;
    private ObjectOutputStream salida; 
    private Ciudad registro_ciudad;
    private ArrayList<Ciudad> lista_ciudad;

    public EscrituraCiudad(String c) {
        noArchivo = c;
        establecerLista_ciudad(); 
        try{
            salida = new ObjectOutputStream(new FileOutputStream(noArchivo));
            if (obtenerLista_ciudad().size() > 0) {
                for (int i = 0; i < obtenerLista_ciudad().size(); i++) {
                    establecerRegistro_ciudad(obtenerLista_ciudad().
                            get(i));
                    establecerSalida();
                }
            }
        } 
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        }
    }
    public void establecerNoArchivo(String c){
        noArchivo = c;
    }
    public void establecerRegistro_ciudad(Ciudad c) {
        registro_ciudad = c;
    }
    public void establecerSalida() {
        try {
            salida.writeObject(registro_ciudad);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }
    public void establecerLista_ciudad() {
        LecturaCiudad le =  new LecturaCiudad(obtenerNoArchivo());
        le.establecerCiudad();
        lista_ciudad = le.obtenerCiudad();
    }

    
    public String obtenerNoArchivo(){
        return noArchivo;
    }
    public ArrayList<Ciudad> obtenerLista_ciudad() {
        return lista_ciudad;
    }
    public ObjectOutputStream obtenerSalida(){
        return salida;
    }
    public void cerrarArchivo() {
        try{
            if (salida != null) {
                salida.close();
            }
        }
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo."); 
        }
    } 

}
