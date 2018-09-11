/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franp
 */
public class Medico {
    private int codigo;
    private String nombre;
    private String apellidos;
    private String especialidad;
    private int planta;

    private static int codigos = 1;
    public Medico(String nombre, String apellidos, String especialidad, int planta) {
        this.codigo = codigos++;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.planta = planta;
    }
    
    public Medico(){
    }

    public static Medico instanceFromStringArray(String[]data) {
        Medico m = new Medico();
        m.codigo = codigos++;
        m.apellidos = data[0];
        m.nombre = data[1];
        m.especialidad = data[2];
        m.planta = Integer.parseInt(data[3]);
        
        return m;
    }
    
    
    
    
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public int getPlanta() {
        return planta;
    }
    public void setPlanta(int planta) {
        this.planta = planta;
    }
    
    
    
}
