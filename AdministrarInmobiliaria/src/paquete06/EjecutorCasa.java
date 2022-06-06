
package paquete06;

import java.util.Scanner;
import paquete02.BusquedaPropietario;
import paquete02.EjecutorPropietario;
import paquete03.BusquedaBarrio;
import paquete03.EjecutorBarrio;
import paquete04.BusquedaCiudad;
import paquete04.EjecutorCiudad;
import paquete05.BusquedaConstructora;
import paquete05.EjecutorConstructora;

public class EjecutorCasa {
    public static void main(String[] args) {

        String nombreArchivoC = "data/casa.data";
        
        Scanner sc = new Scanner(System.in);
        
         //Ejecutores de su propia clase.
        EjecutorPropietario objProp = new  EjecutorPropietario();
        EjecutorCiudad objCity = new EjecutorCiudad();
        EjecutorBarrio objBarrio = new EjecutorBarrio();
        EjecutorConstructora objCons = new EjecutorConstructora();
        
        //Buscadores de su propia clase
        BusquedaPropietario objPropBus = new BusquedaPropietario();
        BusquedaCiudad objCityBus = new BusquedaCiudad();
        BusquedaBarrio objBarrioBus = new BusquedaBarrio();
        BusquedaConstructora objConsBus = new BusquedaConstructora();
        
        EscrituraCasa es = new EscrituraCasa(nombreArchivoC);
        LecturaCasa le = new LecturaCasa(nombreArchivoC);       
        
        int nc;
        double nmc;
        double pmc;
        
        int op;
        
        System.out.println("--------Datos de la Casa--------");
        System.out.println("PROPIETARIO");
        
        System.out.println("1.Nuevo Propietario");
        System.out.println("2.Busqueda de Propietario");
        op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1:
                objProp.main(args);
                break;
            case 2:
                objPropBus.main(args);
                break;
        }
        
        
        System.out.println("Valores");
        //datos a dijitar
        System.out.println("Ingrese el precio por metro cuadrado: ");
        pmc = sc.nextDouble();
        System.out.println("Ingrese el numero de metros cuadrados: ");
        nmc = sc.nextDouble();
       
        
        System.out.println("BARRIO");
        System.out.println("Nuevo Barrio            [1]");
        System.out.println("Busqueda del Barrio     [2]");
        op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1:
                objBarrio.main(args);
                break;
            case 2:
                objBarrioBus.main(args);
                break;
        }
        
            
        System.out.println("----CIUDAD----");
        System.out.println("1.Nueva Ciudad            [1]");
        System.out.println("2.Busqueda del Ciudad");
        op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1:
                objCity.main(args);
                break;
            case 2:
                objCityBus.main(args);
                break;
        }
       
        
        System.out.println("Ingrese el numero de cuartos: ");
        nc = sc.nextInt();
       
        
        System.out.println("CONSTRUCTORA");
        System.out.println("Nuevo/a constructor/ra");
        System.out.println("Busqueda del/la constructor/ra   [2]");
        op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1:
                objCons.main(args);
                break;
            case 2:
                objConsBus.main(args);
                break;
        }
        
        Casa casa = new Casa( nc, nmc, pmc);
        
        casa.obtenerCosto_final();
        
        es.establecerRegistroCasa(casa);
        es.establecerSalida();
        
        le.establecerCasa();
        //falta especificar
        System.out.println(le);
    }
}
