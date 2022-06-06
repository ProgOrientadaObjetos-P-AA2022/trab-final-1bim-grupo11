/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete06;

import java.io.Serializable;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

/**
 *
 * @author reroes
 */
public class Casa implements Serializable{

    private Propietario propietario_1;//Instanciamos una variable de tipo propietario
    private Barrio barrio;//Instanciamos una variable de tipo barrio
    private Ciudad ciudad;//Instanciamos una variable de tipo ciudad   
    private Constructora constructora;//Instanciamos una variable de tipo constructora
    private int numero_de_cuartos;
    private double número_de_metros_cuadrados;
    private double precio_por_metro_cuadrado;
    private double costo_final;

    // Constructor
    public Casa( int nc, double nmc, double pmc) {
        numero_de_cuartos = nc;
        número_de_metros_cuadrados = nmc;
        precio_por_metro_cuadrado = pmc;
    }
    
    // Los establecer de los atributos
    public void establecerPropietario_1(Propietario c){
        propietario_1 = c;
    }
    public void establecerBarrio(Barrio c){
        barrio = c;
    }
    public void establecerCiudad(Ciudad c){
        ciudad = c;
    } 
    public void establecerConstructora(Constructora c){
        constructora = c;
    }
    public void establecerNumero_de_cuartos(int c){
        numero_de_cuartos = c;
    }
    public void establecerNúmero_de_metros_cuadrados(double c){
        número_de_metros_cuadrados = c;
    }
    public void establecerPrecio_por_metro_cuadrado(double c){
        precio_por_metro_cuadrado = c;
    }
    public void establecerCosto_final(){
        costo_final =  número_de_metros_cuadrados *precio_por_metro_cuadrado;
    }
    
    public Propietario obtenerPropietario_1 (){
        return propietario_1;
    }
    public Barrio obtenerBarrio (){
        return barrio;
    }
    public Ciudad obtenerCiudad (){
        return ciudad;
    } 
    public Constructora obtenerConstructora (){
        return constructora;
    }
    public int obtenerNumero_de_cuartos (){
        return numero_de_cuartos;
    }
    public double obtenerNúmero_de_metros_cuadrados (){
        return número_de_metros_cuadrados;
    }
    public double obtenerPrecio_por_metro_cuadrado (){
        return precio_por_metro_cuadrado;
    }
    public double obtenerCosto_final (){
        return costo_final;
    }
    
    @Override
    public String toString(){
        String c = String.format("Casa\nNumero de cuartos: %d\n"
                + "Número de metros cuadrados: %2f\nPrecio por metro "
                + "cuadrado: %2f\n" 
                + "Número de metros cuadrados2: %2f\nPrecio por metro "
                + "cuadrado2: %2f\n"
                ,obtenerNumero_de_cuartos()
                ,obtenerNúmero_de_metros_cuadrados()
                ,obtenerPrecio_por_metro_cuadrado ()
                );
        return c;
    }
    

    
   

    
}
