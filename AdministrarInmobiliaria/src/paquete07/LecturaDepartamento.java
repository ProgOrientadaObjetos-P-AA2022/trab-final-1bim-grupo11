
package paquete07;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecturaDepartamento {

    private ObjectInputStream entrada;
    private ArrayList<Departamento> depar;
    private String noArchivo;

    //Constructor
    public LecturaDepartamento(String n) {
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
    public void establecerDepar() {
        depar = new ArrayList<>();
        File f = new File(obtenerNoArchivo());
        if (f.exists()) {
            while (true) {
                try {
                    Departamento reg = (Departamento) entrada.readObject();
                    depar.add(reg);
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
    public ArrayList<Departamento> obtenerDepartamento() {
        return depar;
    }
    public String obtenerNoArchivo() {
        return noArchivo;
    }

    //Metodo toString
    @Override
    public String toString() {
        String ca = "Lista de Departamento\n";
        for (int i = 0; i < obtenerDepartamento().size(); i++) {
            Departamento c = obtenerDepartamento().get(i);
            ca = String.format("%s(%d) Propietario \t[%s-%s-%s]\n"
                    + "Barrio.. \t[%s-%s]\n"
                    + "Ciudad.. \t[%s-%s]\n"
                    + "Constructora.. \t[%s-%s]\n"
                    + "Nombre del edificio: %s\n"
                    + "Ubicacion del edificio: %s\n"
                    + "Valor alicuota mensual: %.2f\n"
                    + "Numero de metros cuadrados: %.2f\n"
                    + "Precio por metro cuadrado:  %.2f\n"
                    + "Costo final: %.2f\n"
                    ,ca
                    ,i + 1
                    ,c.obtenerPropietario2().obtenerNombres()
                    ,c.obtenerPropietario2().obtenerApellidos()
                    ,c.obtenerPropietario2().obtenerIdentificacion()
                    ,c.obtenerBarrio2().obtenerNombre_barrio()
                    ,c.obtenerBarrio2().obtenerReferencia()
                    ,c.obtenerCiudad2().obtenerNombre_ciudad()
                    ,c.obtenerCiudad2().obtenerNombre_provincia()
                    ,c.obtenerConstructora2().obtenerNombre_constructora()
                    ,c.obtenerNombre_edificio()
                    ,c.obtenerValor_alicuotaMes()
                    ,c.obtenerNúmero_de_metros_cuadrados2()
                    ,c.obtenerPrecio_por_metro_cuadrado2()
                    ,c.obtenerCosto_final2()
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
