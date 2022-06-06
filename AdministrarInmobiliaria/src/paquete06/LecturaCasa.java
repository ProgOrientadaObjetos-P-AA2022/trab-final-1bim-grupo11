/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete06;

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
import paquete06.Casa;

public class LecturaCasa {

    private ObjectInputStream entrada;
    private ArrayList<Casa> casa;
    private String noArchivo;

    //Constructor
    public LecturaCasa(String n) {
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
    public void establecerCasa() {
        casa = new ArrayList<>();
        File f = new File(obtenerNoArchivo());
        if (f.exists()) {
            while (true) {
                try {
                    Casa reg = (Casa) entrada.readObject();
                    casa.add(reg);
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
    public ArrayList<Casa> obtenerCasa() {
        return casa;
    }
    public String obtenerNoArchivo() {
        return noArchivo;
    }

    //Metodo toString
    @Override
    public String toString() {
        String ca = "Lista de Casa\n";
        
        for (int i = 0; i < obtenerCasa().size(); i++) {
            Casa c = obtenerCasa().get(i);
            ca = String.format("%s(%d) Propietario: \n\t\t[%s-%s-%s]\n"
                    + "Barrio: \n\t\t[%s-%s]\nCiudad: \n\t\t[%s-%s]\n"
                    + "Constructora: \n\t\t[%s-%s]\n\n"
                    + "Costo total de la propiedad es: %.2f\n"
                    ,ca
                    ,i + 1
                    ,c.obtenerPropietario_1().obtenerNombres()
                    ,c.obtenerPropietario_1().obtenerApellidos()
                    ,c.obtenerPropietario_1().obtenerIdentificacion()
                    ,c.obtenerBarrio().obtenerNombre_barrio()
                    ,c.obtenerBarrio().obtenerReferencia()
                    ,c.obtenerCiudad().obtenerNombre_ciudad()
                    ,c.obtenerCiudad().obtenerNombre_provincia()
                    ,c.obtenerConstructora().obtenerNombre_constructora()
                    ,c.obtenerConstructora().obtenerId_de_la_empresa()
                    ,c.obtenerCosto_final()
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
