
package paquete02;

import java.util.Scanner;

public class BusquedaPropietario {
    
    public static void main(String[] args) {
        String nombreArchivoP = "data/propietario.data";
        String ce;
        Propietario pro_buscar;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("BUSQUEDA DE PROPIETARIO");
        System.out.println("Ingrese la cedula del propietario: ");
        ce = sc.nextLine();

        LecturaPropietario lectura = new LecturaPropietario(nombreArchivoP);
        
        lectura.establecerIdent(ce);
        lectura.establecerPropBusqueda();
        pro_buscar = lectura.obtenerPropBusqueda();

        if (pro_buscar != null) {
            System.out.println("------ENCONTRADO------");
            System.out.println(pro_buscar);
        } else {
            System.out.println("**********");
            System.out.println("PROPIETARIO no encontrado");
            System.out.println("**********");
        }
    }
    
}
