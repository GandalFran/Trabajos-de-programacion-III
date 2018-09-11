/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author franp
 */
public class Paciente implements Serializable{
    private int dni;
    private String nombre;
    private String ape1;
    private String ape2;
    private List<Ingreso>listaIngresos;
    
    private static int dnis = 0;
    public Paciente(String nombre, String ape1, String ape2) {
        this.dni = dnis++;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.listaIngresos = new ArrayList<>();
    }
    public Paciente(int dni){
        this.dni = dni;
    }
    public Paciente(){
        this.listaIngresos = new ArrayList<>();
    }
    
    public boolean annadirIngreso(String[]data){
        this.listaIngresos.add(Ingreso.instanceFromStringArray(data));
        Collections.sort(this.listaIngresos);
        return true;
    }
    
    public static Paciente instanceFromStringArray(String[]data){
        Paciente p = new Paciente();
        if(data.length == 3){
            p.dni = dnis++;
            p.nombre = data[0]; 
            p.ape1 = data[1]; 
            p.ape2 = data[2]; 
        }else{
            p.dni = Integer.parseInt(data[0]);
            p.nombre = data[1]; 
            p.ape1 = data[2]; 
            p.ape2 = data[3]; 
            if(p.dni > dnis) dnis = p.dni;
        }
        return p;
    }
    
    
    public String toHtmlString(){
        return "<TR><TD> " + this.dni + " </TD><TD> " + this.ape1 + " </TD><TD> " + this.ape2 + " </TD><TD> " + this.nombre + " </TD></TR>";
    }
    
    public String toCsvString(){
        return String.format("%d\t%s\t%s\t%s",this.dni,this.ape1,this.ape2,this.nombre);
    }
    
    @Override
    public String toString(){
        return String.format("%d*%s*%s*%s",this.dni,this.ape1,this.ape2,this.nombre);
    }
    
    

    public int getDni() {
        return dni;
    }
    public void setDNI(int dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApe1() {
        return ape1;
    }
    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }
    public String getApe2() {
        return ape2;
    }
    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }
    public List<Ingreso> getListaIngresos() {
        return listaIngresos;
    }   
}
