
package paquete04;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecturaCiudad {

    private ObjectInputStream entrada;
    private ArrayList<Ciudad> ciudad;
    private String noArchivo;
    private String ident;
    private Ciudad busqueda_ciudad;

    //Constructor
    public LecturaCiudad(String n) {
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
    public void establecerCiudad() {
        ciudad = new ArrayList<>();
        File f = new File(obtenerNoArchivo());
        if (f.exists()) {
            while (true) {
                try {
                    Ciudad reg = (Ciudad) entrada.readObject();
                    ciudad.add(reg);
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
    public void establecerCityBusqueda() {
        File f = new File(obtenerNoArchivo());
        if (f.exists()) {
            while (true) {
                try {
                    Ciudad reg = (Ciudad) entrada.readObject();
                    if(reg.obtenerNombre_ciudad().equals(ident)){
                        busqueda_ciudad = reg;
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
    public ArrayList<Ciudad> obtenerCiudad() {
        return ciudad;
    }
    public String obtenerNoArchivo() {
        return noArchivo;
    }
    public String obtenerIdent() {
        return ident;
    }
    public Ciudad obtenerCityBusqueda() {
        return busqueda_ciudad;
    }

    //Metodo toString
    @Override
    public String toString() {
        String ca = "Lista de Ciudades\n";
        for (int i = 0; i < obtenerCiudad().size(); i++) {
            Ciudad c = obtenerCiudad().get(i);
            ca = String.format("%s(%d) %s - %s\n"
                    ,ca
                    ,i + 1
                    ,c.obtenerNombre_ciudad()
                    ,c.obtenerNombre_provincia()
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
