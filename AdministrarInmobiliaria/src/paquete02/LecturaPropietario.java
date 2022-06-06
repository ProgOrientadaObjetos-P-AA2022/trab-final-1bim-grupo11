
package paquete02;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecturaPropietario {

    private ObjectInputStream entrada;
    private ArrayList<Propietario> prop;
    private String noArchivo;
    private String ident;
    private Propietario propBusqueda;

    //Constructor
    public LecturaPropietario(String n) {
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
    public void establecerProp() {
        prop = new ArrayList<>();
        File f = new File(obtenerNoArchivo());
        if (f.exists()) {
            while (true) {
                try {
                    Propietario reg = (Propietario) entrada.readObject();
                    prop.add(reg);
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
    public void establecerPropBusqueda() {
        File f = new File(obtenerNoArchivo());
        if (f.exists()) {
            while (true) {
                try {
                    Propietario reg = (Propietario) entrada.readObject();
                    if(reg.obtenerIdentificacion().equals(ident)){
                        propBusqueda = reg;
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
    public ArrayList<Propietario> obtenerProp() {
        return prop;
    }
    public String obtenerNoArchivo() {
        return noArchivo;
    }
    public String obtenerIdent() {
        return ident;
    }
    public Propietario obtenerPropBusqueda() {
        return propBusqueda;
    }

    //Metodo toString
    @Override
    public String toString() {
        String c = "Lista de Propietarios\n";
        for (int i = 0; i < obtenerProp().size(); i++) {
            Propietario p = obtenerProp().get(i);
            c = String.format("%s(%d) %s - %s - %s\n"
                    ,c
                    ,i + 1
                    ,p.obtenerNombres()
                    ,p.obtenerApellidos()
                    ,p.obtenerIdentificacion()
            );
        }
        return c;
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
