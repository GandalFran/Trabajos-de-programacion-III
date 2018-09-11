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
public class DatosPersonales {
    private String nombre;
    private String apellidos;
    private int edad;
    private String NIF;

    public DatosPersonales(String nombre, String apellidos, int edad, String NIF) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.NIF = NIF;
    }
    public DatosPersonales(){
        this.nombre = null;
        this.apellidos = null;
        this.edad = 0;
        this.NIF = null;
    }
    
    public static void factoryMethod(DatosPersonales p){
        Random r = new Random();
        
        p.nombre=Constantes.nombres[r.nextInt(Constantes.nombres.length)];
        p.apellidos=Constantes.apellidos[r.nextInt(Constantes.apellidos.length)] + " " + Constantes.apellidos[r.nextInt(Constantes.apellidos.length)];
        p.edad=r.nextInt(Constantes.MAX_EDAD - Constantes.MIN_EDAD + 1) + Constantes.MIN_EDAD;
        p.NIF= Constantes.DNIs[r.nextInt(Constantes.DNIs.length)];
    }

    @Override
    public String toString() {
        return String.format("\n|%20s, %10s|%5d|%9s|",this.apellidos,this.nombre,this.edad,this.NIF);
    }
    
    public String toHTMLString(){
        return String.format("<TR> <TD>%20s, %10s</TD> <TD>%5d</TD> <TD>%9s</TD> </TR>",this.apellidos,this.nombre,this.edad,this.NIF);
    }
    
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getNIF() {
        return NIF;
    }
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }
    
    
    
}
