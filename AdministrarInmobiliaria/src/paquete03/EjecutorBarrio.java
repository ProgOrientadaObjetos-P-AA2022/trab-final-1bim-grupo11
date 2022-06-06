
package paquete03;

import java.util.Scanner;

public class EjecutorBarrio {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String nombreArchivoB = "data/barrio.data";
        
        EscrituraBarrio e = new EscrituraBarrio(nombreArchivoB);
        
        String nom;
        String ref;

        System.out.println("--------Datos de la Ciudad--------");
        System.out.println("Nombre barrio: ");
        nom = sc.nextLine();
        System.out.println("Ingrese la referencia: ");
        ref = sc.nextLine();

        Barrio b = new Barrio(nom,ref);
        
        e.establecerRegistroBarrio(b);
        e.establecerSalida();
        
        e.cerrarArchivo();
        
        LecturaBarrio lectura = new LecturaBarrio(nombreArchivoB);
        lectura.establecerBarrio();
        
        System.out.println(lectura);
    }
}
