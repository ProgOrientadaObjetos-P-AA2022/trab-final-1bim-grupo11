
package paquete05;

import java.util.Scanner;

public class EjecutorConstructora {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String nombreArchivoCo = "data/constructora.data";
        
        EscrituraConstructora e = new EscrituraConstructora(nombreArchivoCo);

        String nomC;
        String id;
        
        System.out.println("-------Datos del la Constructor-------");
        System.out.println("Ingrese el nombre: ");
        nomC = sc.nextLine();
        System.out.println("Ingrese el id de la empresa: ");
        id = sc.nextLine();
        
        Constructora c = new Constructora(nomC, id);
        
        e.establecerRegistroConstructora(c);
        e.establecerSalida();
        
        e.cerrarArchivo();
        
        LecturaConstructora lectura = new LecturaConstructora(nombreArchivoCo);
        lectura.establecerConstruct();
        
        System.out.println(lectura);
    }
}
