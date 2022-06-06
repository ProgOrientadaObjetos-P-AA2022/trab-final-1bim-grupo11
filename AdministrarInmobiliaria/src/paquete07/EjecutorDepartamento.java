
package paquete07;

import java.util.Scanner;
import paquete02.BusquedaPropietario;
import paquete02.EjecutorPropietario;
import paquete03.BusquedaBarrio;
import paquete03.EjecutorBarrio;
import paquete04.BusquedaCiudad;
import paquete04.EjecutorCiudad;
import paquete05.BusquedaConstructora;
import paquete05.EjecutorConstructora;


public class EjecutorDepartamento {
    public static void main(String[] args) {

        String nombreArchivoD = "data/departamento.data";
        
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
        
        EscrituraDepartamento es = new EscrituraDepartamento(nombreArchivoD);
        LecturaDepartamento le = new LecturaDepartamento(nombreArchivoD);       
        
        String ne;
        String ue; 
        double va; 
        double nmc; 
        double pmc;
        
        int op;
        
        System.out.println("--------Datos del departamento--------");
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
        System.out.println("Ingrese el valor alicuota mensual: ");
        va = sc.nextDouble();
       
        
        System.out.println("----BARRIO----");
        System.out.println("1.Nuevo Barrio");
        System.out.println("2.Busqueda del Barrio");
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
        System.out.println("1.Nueva Ciudad");
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
       
        
        System.out.println("Ingrese el nombre del edificio: ");
        ne = sc.nextLine();
        System.out.println("Ingrese la ubicacion del edificio: ");
        ue = sc.nextLine();
       
        
        System.out.println("----CONSTRUCTORA----");
        System.out.println("1.Nuevo/a constructor/ra");
        System.out.println("2.Busqueda del/la constructor/ra");
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
//      }
        
        Departamento depatament = new Departamento(ne, ue, va, nmc, pmc);
        
        depatament.obtenerCosto_final2();
        
        es.establecerRegistroDepartamento(depatament);
        es.establecerSalida();
        
        le.establecerDepar();
        //falta especificar
        System.out.println(le);
        
    }
}