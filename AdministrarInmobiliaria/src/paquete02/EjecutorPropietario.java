
package paquete02;

import java.util.Scanner;

public class EjecutorPropietario {
    public static void main(String[] args) {

        String nombreArchivoP = "data/propietario.data";
        String nom;
        String ape;
        String ced;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("--------Datos del propietario--------");
        System.out.println("nombre: ");
        nom = sc.nextLine();
        System.out.println("apellido: ");
        ape = sc.nextLine();
        System.out.println("cedula: ");
        ced = sc.nextLine();
        
        Propietario p0 = new Propietario(nom,ape,ced);
        EscrituraPropietario e = new EscrituraPropietario(nombreArchivoP);
        
        e.establecerRegistroProp(p0);
        e.establecerSalida();
        
        e.cerrarArchivo();
        
        LecturaPropietario lectura = new LecturaPropietario(nombreArchivoP);
        lectura.establecerProp();
        
        System.out.println(lectura);
        
    }
}
