
package paquete01;

import java.util.Scanner;
import paquete02.BusquedaPropietario;
import paquete02.EjecutorPropietario;
import paquete03.BusquedaBarrio;
import paquete03.EjecutorBarrio;
import paquete04.BusquedaCiudad;
import paquete04.EjecutorCiudad;
import paquete05.BusquedaConstructora;
import paquete05.EjecutorConstructora;
import paquete06.EjecutorCasa;
import paquete07.EjecutorDepartamento;

/**
 *
 * @author reroes
 */
public class Ejecutor {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int op = -1;
    int opc;
    
    EjecutorPropietario prop = new EjecutorPropietario();
    EjecutorBarrio bar = new EjecutorBarrio();
    EjecutorCiudad ciu = new EjecutorCiudad();
    EjecutorConstructora con= new EjecutorConstructora();
    EjecutorCasa casa = new EjecutorCasa();
    EjecutorDepartamento depa = new EjecutorDepartamento();
    
    ImpresionDatos id = new ImpresionDatos();
    
    BusquedaPropietario busprop = new BusquedaPropietario();
    BusquedaCiudad busciu = new BusquedaCiudad();
    BusquedaBarrio busbar = new BusquedaBarrio();
    BusquedaConstructora buscon = new BusquedaConstructora();
    
    while (op != 0){
        try {
            System.out.println("------------------------------");
            System.out.printf("Elegir la opcion que decea realizar: \n\n"
                    + "1.Ingresar Propietario\n"
                    + "2.Ingresar Ciudad\n"
                    + "3.Ingresar Barrio\n"
                    + "4.Ingresar Constructora\n"
                    + "---------------------\n"
                    + "5.Ingresar una Casa\n"
                    + "6.Ingresar un departamento\n"
                    + "------------------------\n"
                    + "7.Imprimir Datos\n"
                    + "------------------------\n"
                    + "0.Para salir de la aplicaicon pulse\n");
            op = sc.nextInt();
            sc.nextLine();
            System.out.println("------------------------------");
            switch(op){
                case 1:      
                    System.out.println("******************");
                    System.out.println("1.Nuevo propietario");
                    System.out.println("2.Buscar propietario");
                    System.out.println("3.Atras");
                    opc = sc.nextInt();
                    sc.nextLine();
                    switch (opc) {
                        case 1:
                            prop.main(args);
                            break;
                        case 2:
                            busprop.main(args);
                            break;
                        case 0:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1.Nueva Ciudad");
                    System.out.println("2.Buscar Ciudad");
                    System.out.println("0.Atras");
                    opc = sc.nextInt();
                    sc.nextLine();
                    switch (opc) {
                        case 1:
                            ciu.main(args);
                            break;
                        case 2:
                            busciu.main(args);
                            break;
                        case 0:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("******MENU BARRIO******");
                    System.out.println("Nueva Barrio         [1]");
                    System.out.println("Buscar Barrio        [2]");
                    System.out.println("Atras                [0]");
                    opc = sc.nextInt();
                    sc.nextLine();
                    switch (opc) {
                        case 1:
                            bar.main(args);
                            break;
                        case 2:
                            busbar.main(args);
                            break;
                        case 0:
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Nueva Constructora         1");
                    System.out.println("Buscar Constructora        2");
                    System.out.println("Atras                      ]");
                    opc = sc.nextInt();
                    sc.nextLine();
                    switch (opc) {
                        case 1:
                            con.main(args);
                            break;
                        case 2:
                            buscon.main(args);
                            break;
                        case 0:
                            break;
                    }
                    break;
                case 5://No se como arreglarlo
                    System.out.println("******MENU CASA******");
                    casa.main(args);
                    break;
                case 6://No se como arreglarlo 
                    System.out.println("******MENU DEPARTAMENTO******");
                    depa.main(args);  
                    break;
                case 7:
                    id.main(args);
                    break;
            }
            System.out.println("");
        } catch (Exception e) {
            System.out.println("Error al dijitar.");
        }
    }
}
    
    }
    

