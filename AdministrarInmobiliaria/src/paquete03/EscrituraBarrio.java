
package paquete03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscrituraBarrio {

    private String noArchivo;
    private ObjectOutputStream salida; 
    private Barrio registroBarrio;
    private ArrayList<Barrio> listaBarrio;

    public EscrituraBarrio(String c) {
        noArchivo = c;
        establecerListaBarrio(); 
        try{
            salida = new ObjectOutputStream(new FileOutputStream(noArchivo));
            if (obtenerListaBarrio().size() > 0) {
                for (int i = 0; i < obtenerListaBarrio().size(); i++) {
                    establecerRegistroBarrio(obtenerListaBarrio().
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
    public void establecerRegistroBarrio(Barrio c) {
        registroBarrio = c;
    }
    public void establecerSalida() {
        try {
            salida.writeObject(registroBarrio);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }
    public void establecerListaBarrio() {
        LecturaBarrio le =  new LecturaBarrio(obtenerNoArchivo());
        le.establecerBarrio();
        listaBarrio = le.obtenerBarrio();
    }

    
    public String obtenerNoArchivo(){
        return noArchivo;
    }
    public ArrayList<Barrio> obtenerListaBarrio() {
        return listaBarrio;
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
