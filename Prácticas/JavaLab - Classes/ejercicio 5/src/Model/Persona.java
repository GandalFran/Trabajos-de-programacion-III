/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author franp
 */
public class Persona {
    private String nombre;
    private int telefono;
    private float peso;

    public Persona(String nombre, int telefono, float peso) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.peso = peso;
    }

    Persona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return String.format("\n%s\t%d\t%.2f",this.nombre,this.telefono,this.peso);
    }
    
    public static void factoryMethod(Persona p, String tabbedPersona) throws ParseException{
        String[]fragmentos = tabbedPersona.split("\t");
        Locale l = new Locale("es","Es");
        NumberFormat nf = NumberFormat.getInstance(l);
        
        p.nombre = fragmentos[0];
        p.telefono = nf.parse(fragmentos[1]).intValue();
        p.peso = nf.parse(fragmentos[2]).floatValue();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    
}
