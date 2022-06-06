
package paquete05;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecturaConstructora{

    private ObjectInputStream entrada;
    private ArrayList<Constructora> construct;
    private String noArchivo;
    private String ident;
    private Constructora constructoraBu;

    //Constructor
    public LecturaConstructora(String n) {
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
    public void establecerConstruct() {
        construct = new ArrayList<>();
        File f = new File(obtenerNoArchivo());
        if (f.exists()) {
            while (true) {
                try {
                    Constructora reg = (Constructora) entrada.readObject();
                    construct.add(reg);
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
    public void establecerConstructoraBu() {
        File f = new File(obtenerNoArchivo());
        if (f.exists()) {
            while (true) {
                try {
                    Constructora reg = (Constructora) entrada.readObject();
                    if(reg.obtenerId_de_la_empresa().equals(ident)){
                        constructoraBu = reg;
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
    public ArrayList<Constructora> obtenerConstruct() {
        return construct;
    }
    public String obtenerNoArchivo() {
        return noArchivo;
    }
    public String obtenerIdent() {
        return ident;
    }
    public Constructora obtenerConstructoraBu() {
        return constructoraBu;
    }

    //Metodo toString
    @Override
    public String toString() {
        String ca = "Lista de Constructores/as\n";
        for (int i = 0; i < obtenerConstruct().size(); i++) {
            Constructora c = obtenerConstruct().get(i);
            ca = String.format("%s(%d) %s - %s\n"
                    ,ca
                    ,i + 1
                    ,c.obtenerNombre_constructora()
                    ,c.obtenerId_de_la_empresa()
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
