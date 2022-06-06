
package paquete03;

import java.util.Scanner;


public class BusquedaBarrio {
    
    public static void main(String[] args) {
        String nombreArchivoB = "data/barrio.data";
        String nomb;
        Barrio barrio_buscar;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("BUSQUEDA DE LA BARRIO");
        System.out.println("Ingrese el nombre del barrio: ");
        nomb = sc.nextLine();
        
        LecturaBarrio lectura = new LecturaBarrio(nombreArchivoB);
        
        lectura.establecerIdent(nomb);
        lectura.establecerBarrioBusqueda();
        barrio_buscar = lectura.obtenerBarrioBusqueda();

        if (barrio_buscar != null) {
            System.out.println("------ENCONTRADO------");
            System.out.println(barrio_buscar);
        } else {
            System.out.println("**********");
            System.out.println("NOMBRE BARRIO no encontrado");
            System.out.println("**********");
        }
    }
    
}
