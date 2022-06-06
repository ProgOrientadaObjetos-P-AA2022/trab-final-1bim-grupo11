
package paquete05;

import java.util.Scanner;

public class BusquedaConstructora {
    
    public static void main(String[] args) {
        String nombreArchivoC = "data/constructora.data";
        String id;
        Constructora cons_buscar;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("BUSQUEDA DE LA EMPREZA");
        System.out.println("Ingrese id de la empresa: ");
        id = sc.nextLine();
        
        LecturaConstructora lectura = new LecturaConstructora(nombreArchivoC);
        
        lectura.establecerIdent(id);
        lectura.establecerConstructoraBu();
        cons_buscar = lectura.obtenerConstructoraBu();

        if (cons_buscar != null) {
            System.out.println("------ENCONTRADO------");
            System.out.println(cons_buscar);
        } else {
            System.out.println("**********");
            System.out.println("ID DE EMPREZA NO ENCONTRADA");
            System.out.println("**********");
        }
    }
}
