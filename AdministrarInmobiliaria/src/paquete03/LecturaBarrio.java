/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete03;

/**
 *
 * @author maisc
 **/

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquete03.Barrio;

public class LecturaBarrio {

    private ObjectInputStream entrada;
    private ArrayList<Barrio> barrio;
    private String noArchivo;
    private String ident;
    private Barrio barrioBusqueda;

    //Constructor
    public LecturaBarrio(String n) {
        noArchivo = n;
        File f = new File(obtenerNoArchivo());
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            }
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo." + ioException);
            }
        }
    }

    //Los establecer de los atributos
    public void establecerNoArchivo(String n) {
        noArchivo = n;
    }
    public void establecerBarrio() {
        barrio = new ArrayList<>();
        File f = new File(obtenerNoArchivo());
        if (f.exists()) {
            while (true) {
                try {
                    Barrio reg = (Barrio) entrada.readObject();
                    barrio.add(reg);
                } catch (EOFException endOfFileException) {
                    return;
                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);
                }
            }
        }
    }
    public void establecerIdent(String n) {
        ident = n;
    }
    public void establecerBarrioBusqueda() {
        File f = new File(obtenerNoArchivo());
        if (f.exists()) {
            while (true) {
                try {
                    Barrio reg = (Barrio) entrada.readObject();
                    if(reg.obtenerNombre_barrio().equals(ident)){
                        barrioBusqueda = reg;
                        break;
                    }
                } catch (EOFException endOfFileException) {
                    return;
                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);
                }
            }
        }
    }
    
    //Los obtener de los atributos
    public ArrayList<Barrio> obtenerBarrio() {
        return barrio;
    }
    public String obtenerNoArchivo() {
        return noArchivo;
    }
    public String obtenerIdent() {
        return ident;
    }
    public Barrio obtenerBarrioBusqueda() {
        return barrioBusqueda;
    }

    //Metodo toString
    @Override
    public String toString() {
        String ca = "Lista de Barrios\n";
        for (int i = 0; i < obtenerBarrio().size(); i++) {
            Barrio c = obtenerBarrio().get(i);
            ca = String.format("%s(%d) %s - %s\n"
                    ,ca
                    ,i + 1
                    ,c.obtenerNombre_barrio()
                    ,c.obtenerReferencia()
            );
        }
        return ca;
    }

    // cierra el archivo y termina la aplicación
    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        }
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
}
