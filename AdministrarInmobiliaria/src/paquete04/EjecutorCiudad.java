
package paquete04;

import java.util.Scanner;

public class EjecutorCiudad {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String nombreArchivoci = "data/ciudad.data";
        
        EscrituraCiudad e = new EscrituraCiudad(nombreArchivoci);
        
        String nomc;
        String nomp;
        
        System.out.println("---------Datos de la Ciudad--------");
        System.out.println("Nombre ciudad: ");
        nomc = sc.nextLine();
        System.out.println("Nombre provincia: ");
        nomp = sc.nextLine();

        Ciudad c = new Ciudad(nomc, nomp);
        
        e.establecerRegistro_ciudad(c);
        e.establecerSalida();
        
        e.cerrarArchivo();
        
        LecturaCiudad lectura = new LecturaCiudad(nombreArchivoci);
        lectura.establecerCiudad();
        
        System.out.println(lectura);
    }
}
