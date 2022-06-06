
package paquete01;

import java.util.Scanner;
import paquete02.LecturaPropietario;
import paquete03.LecturaBarrio;
import paquete04.LecturaCiudad;
import paquete05.LecturaConstructora;
import paquete06.LecturaCasa;
import paquete07.LecturaDepartamento;

public class ImpresionDatos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int c;
        
        System.out.println("******Imprimir los datos******");
                     
        String depart = "data/departamento.data";
        String casa = "data/casa.data";
        
        String prop= "data/propietario.data";
        String ciu = "data/ciudad.data";
        String barrio = "data/barrio.data";
        String cons = "data/constructora.data";

        LecturaDepartamento ledepa = new LecturaDepartamento(depart);   
        LecturaCasa lecasa = new LecturaCasa(casa);   
        
        LecturaPropietario lepro = new LecturaPropietario(prop);
        LecturaCiudad leciu = new LecturaCiudad(ciu);
        LecturaBarrio leba = new LecturaBarrio(barrio);
        LecturaConstructora lecon = new LecturaConstructora(cons);

        try {
            System.out.println("Que tipo de datos quiere imprimir:");
            System.out.println("1.Datos de Propietario");
            System.out.println("2.Datos del Barrio");
            System.out.println("3.Datos de la Ciudad");
            System.out.println("4.Datos del/la Constructor/ra");
            System.out.println("5.Datos del la Casa");
            System.out.println("6.Datos del Departamento");
            System.out.println("0.Atras");
            
            c = sc.nextInt();
            sc.nextLine();
            
            switch (c) {
                case 1:
                    lepro.establecerProp();
                    System.out.println(lepro);
                    break;
                case 2:
                    leba.establecerBarrio();
                    System.out.println(leba);
                    break;
                case 3:
                    leciu.establecerCiudad();
                    System.out.println(leciu);
                    break;
                case 4:
                    lecon.establecerConstruct();
                    System.out.println(lecon);
                    break;
                case 5:
                    lecasa.establecerCasa();
                    System.out.println(lecasa);
                    break;
                case 6:
                    ledepa.establecerDepar();
                    System.out.println(ledepa);
                    break;
                case 0:
                    break;
            }
        } catch (Exception e) {
        }
    }
}
