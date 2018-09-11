/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Random;
import otros.Constantes;

/**
 *
 * @author franp
 */
public class Trabajador implements Serializable{

    private int dni;
    private String nombre;
    private String apellidos;
    private float salario;
    private LocalDateTime contrato;

    public Trabajador(int dni, String nombre, String apellidos, float salario) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.salario = salario;
        this.contrato = LocalDateTime.now();
    }
    public Trabajador(int dni) {
        this.dni = dni;
        this.contrato = LocalDateTime.now();
    }
    public Trabajador(){
        this.contrato = LocalDateTime.now();
    }
    
    
    public static Trabajador instanceFromStringArray(String[] data)throws ParseException{
        NumberFormat nf = NumberFormat.getInstance(new Locale("es","ES"));
        Trabajador t = new Trabajador();
        t.dni = nf.parse(data[0]).intValue();
        t.apellidos = data[1];
        t.nombre = data[2];
        t.salario = nf.parse(data[3]).floatValue();
        return t;
    }
    static Trabajador instanceFromRandomValues() {
        Trabajador t = new Trabajador();
        Random r = new Random();
        t.dni = Constantes.DNIS[r.nextInt(Constantes.DNIS.length)];
        t.apellidos = Constantes.APELLIDOS[r.nextInt(Constantes.APELLIDOS.length)];
        t.nombre = Constantes.NOMBRES[r.nextInt(Constantes.NOMBRES.length)];
        t.salario = r.nextInt(Constantes.MAX_SALARIO) + r.nextFloat();
        return t;
    }
    
    
    
    public String toHtmlString(){
        return String.format("<TR> <TD>%d</TD> <TD>%s</TD> <TD>%s</TD> <TD>%.2f</TD> <TD>%s</TD> </TR>",this.dni,this.apellidos,this.nombre,this.salario,this.contrato.format(Constantes.FORMATO_FECHAS));
    }
    public String toCsvString(){
        return String.format("%d\t%s\t%s\t%.2f\t%s",this.dni,this.apellidos,this.nombre,this.salario,this.contrato.format(Constantes.FORMATO_FECHAS));
    }
    @Override
    public String toString(){
        return String.format("|%10d|%15s|%10s|%10.2f|%20s|",this.dni,this.apellidos,this.nombre,this.salario,this.contrato.format(Constantes.FORMATO_FECHAS));
    }
    public String[] toStringArray() {
        String[]data = new String[5];
        data[0] = String.valueOf(this.dni);
        data[1] = this.apellidos;
        data[2] = this.nombre;
        data[3] = String.format("%.2f",this.salario);
        data[4] = this.contrato.format(Constantes.FORMATO_FECHAS);
        return data;
    }
    
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public LocalDateTime getContrato() {
        return contrato;
    }

    public void setContrato(LocalDateTime contrato) {
        this.contrato = contrato;
    }
}
