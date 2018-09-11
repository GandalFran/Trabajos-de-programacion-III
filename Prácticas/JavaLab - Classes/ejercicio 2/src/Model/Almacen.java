/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import java.util.Random;

/**
 *
 * @author franp
 */
public class Almacen {
    private float[] precios;
    private int[] ventas;
    
    public Almacen(float[]precios,int[]ventas){
        this.precios = precios;
        this.ventas = ventas;
    }   
    public Almacen(){
        this.precios = new float [Constantes.NUM_PRODUCTOS];
        this.ventas = new int [Constantes.NUM_PRODUCTOS];
    }
    
    
    public static void generateRandomValues(Almacen a){
        Random r = new Random();
        
        for(int j=0; j<Constantes.NUM_PRODUCTOS; j++){
            a.precios[j] = r.nextInt(Constantes.LIM_PRECIOS) + r.nextFloat();
            a.ventas[j] = r.nextInt(Constantes.LIM_VENTAS);
        }
    }
    public float calcularBeneficios(){
        float beneficios = 0;
        
        if(this.precios.length != this.ventas.length)
            return 0f;
        
        for(int i=0; i< this.precios.length; i++)
            beneficios+=this.precios[i]*this.ventas[i];
        
        return beneficios;
    }
    
    
    public float[] getPrecios() {
        return precios;
    }
    public void setPrecios(float[] precios) {
        this.precios = precios;
    }
    public int[] getVentas() {
        return ventas;
    }
    public void setVentas(int[] ventas) {
        this.ventas = ventas;
    }

    
    
}
