/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete07;

/**
 *
 * @author maisc
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import paquete07.Departamento;
import paquete07.LecturaDepartamento;


public class EscrituraDepartamento {

    private String noArchivo;
    private ObjectOutputStream salida; 
    private Departamento registroDepartamento;
    private ArrayList<Departamento> listaDepartamento;

    public EscrituraDepartamento(String c) {
        noArchivo = c;
        establecerListaDepartamento(); 
        try{
            salida = new ObjectOutputStream(new FileOutputStream(noArchivo));
            if (obtenerListaDepartamento().size() > 0) {
                for (int i = 0; i < obtenerListaDepartamento().size(); i++) {
                    establecerRegistroDepartamento(obtenerListaDepartamento().
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
    public void establecerRegistroDepartamento(Departamento c) {
        registroDepartamento = c;
    }
    public void establecerSalida() {
        try {
            salida.writeObject(registroDepartamento);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }
    public void establecerListaDepartamento() {
        LecturaDepartamento le =  new LecturaDepartamento(obtenerNoArchivo());
        le.establecerDepar();
        listaDepartamento = le.obtenerDepartamento();
    }

    
    public String obtenerNoArchivo(){
        return noArchivo;
    }
    public ArrayList<Departamento> obtenerListaDepartamento() {
        return listaDepartamento;
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
