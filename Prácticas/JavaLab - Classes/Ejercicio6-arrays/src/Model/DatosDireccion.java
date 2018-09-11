/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;

/**
 *
 * @author franp
 */
public class DatosDireccion {
    private String calle;
    private int numero;
    private String letra;
    private String DNI;

    public DatosDireccion(String calle, int numero, String letra, String DNI) {
        this.calle = calle;
        this.numero = numero;
        this.letra = letra;
        this.DNI = DNI;
    }
    public DatosDireccion(){
        this.calle = null;
        this.numero = 0;
        this.letra = null;
        this.DNI = null;
    }
    
    public static void factoryMethod(DatosDireccion d){
        Random r = new Random();
        
        if(null == d){
            d=new DatosDireccion();
        }
        
        d.calle=Constantes.calles[r.nextInt(Constantes.calles.length)];
        d.numero=r.nextInt(Constantes.MAX_NUMERO);
        d.letra=Constantes.letras[r.nextInt(Constantes.letras.length)];
        d.DNI=Constantes.DNIs[r.nextInt(Constantes.DNIs.length)];
    }

    @Override
    public String toString() {
        return "DatosDireccion{" + "calle=" + calle + ", numero=" + numero + ", letra=" + letra + ", DNI=" + DNI + '}';
    }
    
    
    
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getLetra() {
        return letra;
    }
    public void setLetra(String letra) {
        this.letra = letra;
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
