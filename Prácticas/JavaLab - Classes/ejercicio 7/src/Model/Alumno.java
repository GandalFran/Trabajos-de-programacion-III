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
public class Alumno {

    private String ape1;
    private String ape2;
    private String nombre;
    private String DNI;
    private boolean[]asistencia;

    public Alumno(String ape1, String ape2, String nombre, String DNI, boolean[] asistenacia) {
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.nombre = nombre;
        this.DNI = DNI;
        this.asistencia = asistenacia;
    }
    public Alumno() {
        this.ape1 = null;
        this.ape2 = null;
        this.nombre = null;
        this.DNI = null;
        this.asistencia = null;
    }

    
    public static void factoryMethod(Alumno a){
        Random r = new Random();
        
        if(null == a)
            a = new Alumno();
        
        boolean[] b = new boolean[Constantes.NUM_ASISTENCIAS];
        for(int i=0; i<b.length;i++)
            b[i]=r.nextBoolean();
        
        a.DNI=Constantes.DNIs[r.nextInt(Constantes.DNIs.length)];
        a.ape1=Constantes.apellidos[r.nextInt(Constantes.apellidos.length)];
        a.ape2=Constantes.apellidos[r.nextInt(Constantes.apellidos.length)];;
        a.nombre=Constantes.nombres[r.nextInt(Constantes.nombres.length)];;
        a.asistencia=b;
    }

  
    public static float calculateTasaAsistencia(Alumno a){
        int diasPresente = 0;
        
        for(boolean d : a.getAsistencia()){
            if(d)
                diasPresente++;
        }
        
        return (diasPresente/a.getAsistencia().length);
    }
    public String generateAsistenciaString(){
        StringBuilder sb = new StringBuilder();
        
        for(boolean b : this.asistencia){
            sb.append(b?"S ":"N ");
        }
        
        return sb.toString();
    }
    
    
    @Override
    public String toString(){
        return String.format("\n|%10s %10s, %10s|%9s|%30s|",this.ape1,this.ape2,this.nombre,this.DNI,this.generateAsistenciaString());
    }
    public String toHtmlString(){
        return String.format("<TR> <TD>%10s %10s, %10s</TD> <TD>%9s</TD> <TD>%30s</TD> </TR>",this.ape1,this.ape2,this.nombre,this.DNI,this.generateAsistenciaString());
    }
    public String toTabbedString(){
        return String.format("%10s\t%10s\t%10s\t%9s\t%30s|",this.ape1,this.ape2,this.nombre,this.DNI,this.generateAsistenciaString());
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
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    public boolean[] getAsistencia() {
        return asistencia;
    }
    public void setAsistencia(boolean[] asistencia) {
        this.asistencia = asistencia;
    }

}
