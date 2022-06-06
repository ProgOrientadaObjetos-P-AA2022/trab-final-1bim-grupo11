/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete06;

/**
 *
 * @author maisc
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import paquete06.Casa;

public class EscrituraCasa {

    private String noArchivo;
    private ObjectOutputStream salida; 
    private Casa registroCasa;
    private ArrayList<Casa> listaCasa;

    public EscrituraCasa(String c) {
        noArchivo = c;
        establecerListaCasa(); 
        try{
            salida = new ObjectOutputStream(new FileOutputStream(noArchivo));
            if (obtenerListaCasa().size() > 0) {
                for (int i = 0; i < obtenerListaCasa().size(); i++) {
                    establecerRegistroCasa(obtenerListaCasa().
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
    public void establecerRegistroCasa(Casa c) {
        registroCasa = c;
    }
    public void establecerSalida() {
        try {
            salida.writeObject(registroCasa);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }
    public void establecerListaCasa() {
        LecturaCasa le =  new LecturaCasa(obtenerNoArchivo());
        le.establecerCasa();
        listaCasa = le.obtenerCasa();
    }

    
    public String obtenerNoArchivo(){
        return noArchivo;
    }
    public ArrayList<Casa> obtenerListaCasa() {
        return listaCasa;
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
