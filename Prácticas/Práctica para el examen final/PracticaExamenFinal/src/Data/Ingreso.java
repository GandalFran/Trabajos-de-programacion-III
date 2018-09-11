/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author franp
 */
public class Ingreso implements Comparable, Serializable{
    private LocalDateTime fecha;
    private String causa;
    private int dniPaciente;
    private int numMedico;

    public Ingreso(int dniPaciente, int numMedico, String causa) {
        this.fecha = LocalDateTime.now();
        this.causa = causa;
        this.dniPaciente = dniPaciente;
        this.numMedico = numMedico;
    }
    
    public static Ingreso instanceFromStringArray(String[]data){
        Ingreso i;
        try{
            i = new  Ingreso(Integer.parseInt(data[0]),Integer.parseInt(data[1]),data[2]);
        }catch(NumberFormatException e){
            return null;
        }
        return i;
    }
    
    
    @Override
    public int compareTo(Object o){
        Ingreso i = (Ingreso) o;
        return this.fecha.compareTo(i.fecha);
    }
    
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public String getCausa() {
        return causa;
    }
    public void setCausa(String causa) {
        this.causa = causa;
    }
    public int getDniPaciente() {
        return dniPaciente;
    }
    public void setDniPaciente(int dniPaciente) {
        this.dniPaciente = dniPaciente;
    }
    public int getNumMedico() {
        return numMedico;
    }
    public void setNumMedico(int numMedico) {
        this.numMedico = numMedico;
    }

}
