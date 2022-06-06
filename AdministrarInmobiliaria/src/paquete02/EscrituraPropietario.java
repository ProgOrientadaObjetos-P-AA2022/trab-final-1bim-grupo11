
package paquete02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscrituraPropietario {

    private String noArchivo;
    private ObjectOutputStream salida; 
    private Propietario registroProp;
    private ArrayList<Propietario> listaProp;

    public EscrituraPropietario(String c) {
        noArchivo = c;
        establecerListaProp(); 
        try{
            salida = new ObjectOutputStream(new FileOutputStream(noArchivo));
            if (obtenerListaProp().size() > 0) {
                for (int i = 0; i < obtenerListaProp().size(); i++) {
                    establecerRegistroProp(obtenerListaProp().
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
    public void establecerRegistroProp(Propietario c) {
        registroProp = c;
    }
    public void establecerSalida() {
        try {
            salida.writeObject(registroProp);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }
    public void establecerListaProp() {
        LecturaPropietario le =  new LecturaPropietario(obtenerNoArchivo());
        le.establecerProp();
        listaProp = le.obtenerProp();
    }

    
    public String obtenerNoArchivo(){
        return noArchivo;
    }
    public ArrayList<Propietario> obtenerListaProp() {
        return listaProp;
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
