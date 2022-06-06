
package paquete04;

import java.util.Scanner;

public class BusquedaCiudad {
    
    public static void main(String[] args) {
        String nombreArchivoci = "data/ciudad.data";
        String nomb;
        Ciudad buscar_ciudad;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("BUSQUEDA DE LA CIUDAD");
        System.out.println("Ingrese el nombre de la ciudad: ");
        nomb = sc.nextLine();
        
        LecturaCiudad lectura = new LecturaCiudad(nombreArchivoci);
        
        lectura.establecerIdent(nomb);
        lectura.establecerCityBusqueda();
        buscar_ciudad = lectura.obtenerCityBusqueda();

        if (buscar_ciudad != null) {
            System.out.println("------ENCONTRADO------");
            System.out.println(buscar_ciudad);
        } else {
            System.out.println("**********");
            System.out.println("NOMBRE DE CIUDAD no encontrado");
            System.out.println("**********");
        }
    }
    
}
