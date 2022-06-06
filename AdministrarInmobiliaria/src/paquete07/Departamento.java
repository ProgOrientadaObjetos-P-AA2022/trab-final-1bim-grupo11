/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete07;

import java.io.Serializable;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

/**
 *
 * @author reroes
 */
public class Departamento implements Serializable{
    private Propietario propietario2;//Instanciamos una variable de tipo propietario
    private Propietario[] propietario;//Instanciamos otra variable de tipo propietario
    private Barrio barrio2;//Instanciamos una variable de tipo barrio
    private Ciudad ciudad2;//Instanciamos una variable de tipo ciudad   
    private Constructora constructora2;//Instanciamos una variable de tipo constructora
    private String nombre_edificio;
    private String ubicacion_edificio;
    private double valor_alicuotaMes;
    private double número_de_metros_cuadrados2;
    private double precio_por_metro_cuadrado2;
    private double costo_final2;
    
    // Constructor

    public Departamento(String ne, String ue, double va, double nmc, double pmc) {
        nombre_edificio = ne;
        ubicacion_edificio = ue;
        valor_alicuotaMes = va;
        número_de_metros_cuadrados2 = nmc;
        precio_por_metro_cuadrado2 = pmc;
    }

    // Los establecer de los atributos
    public void establecerPropietario2(Propietario d){
        propietario2 = d;
    }
    public void establecerPropietario(Propietario [] d){
        propietario = d;
    }
    public void establecerBarr2(Barrio d){
        barrio2 = d;
    }
    public void establecerCiud2(Ciudad d){
        ciudad2 = d;
    }
    public void establecerConstructora2(Constructora d){
        constructora2 = d;
    }
    public void establecerNombre_edificio(String d){
        nombre_edificio = d;
    }
    public void establecerUbicacion_edificio(String d){
        ubicacion_edificio = d;
    }
    public void establecerValor_alicuotaMes(double d){
        valor_alicuotaMes = d;
    }
    public void establecerNúmero_de_metros_cuadrados2(double d){
        número_de_metros_cuadrados2 = d;
    }
    public void establecerPrecio_por_metro_cuadrado2(double d){
        precio_por_metro_cuadrado2 = d;
    }
    public void calcularCosto_final2(){
        costo_final2 = (número_de_metros_cuadrados2 * precio_por_metro_cuadrado2)
                + (valor_alicuotaMes * 12);   
    }
    
    // Los obtener de los atributos
    public Propietario obtenerPropietario2(){
       return propietario2; 
    }
    public Propietario [] obtenerPropietario(){
       return propietario; 
    }
    public Barrio obtenerBarrio2(){
        return barrio2;
    }
    public Ciudad obtenerCiudad2(){
        return ciudad2;
    }
    public Constructora obtenerConstructora2(){
        return constructora2;
    }
    public String obtenerNombre_edificio(){
        return nombre_edificio;
    }
    public String obtenerUbicacion_edificio(){
        return ubicacion_edificio;
    }
    public double obtenerValor_alicuotaMes(){
        return valor_alicuotaMes;
    }
    public double obtenerNúmero_de_metros_cuadrados2(){
        return número_de_metros_cuadrados2;
    }
    public double obtenerPrecio_por_metro_cuadrado2(){
        return precio_por_metro_cuadrado2;
    }
    public double obtenerCosto_final2(){
        return costo_final2;
    }
    
    // Metodo toString
    @Override
    public String toString(){
        String d = String.format("Departamento\nNombre del edificio: %s\n"
                + "Ubicacion del edificio: %s\nValor del Alquiler: %2f\n" 
                + "Número de metros cuadrados2: %2f\nPrecio por metro "
                + "cuadrado2: %2f\n"
                ,obtenerNombre_edificio()
                ,obtenerUbicacion_edificio()
                ,obtenerValor_alicuotaMes()
                ,obtenerNúmero_de_metros_cuadrados2()
                ,obtenerPrecio_por_metro_cuadrado2()
                );
        return d;
    }
}
