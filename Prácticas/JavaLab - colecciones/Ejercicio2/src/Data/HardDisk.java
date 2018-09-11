/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Others.Constantes;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author franp
 */
public class HardDisk implements Comparable, Serializable{

    private String fabricante;
    private float megabytes;
    private String modelo;
    private final String numeroDeSerie;
    private int tasaDeTransmision;
    private String tecnologia;
    private String tipoDeInterface;
    private int velocidadDeRotacion;
    
    public HardDisk(String fabricante, float megabytes, String modelo, int tasaDeTransmision, String tecnologia, String tipoDeInterface, int velocidadDeRotacion) {
        this.fabricante = fabricante;
        this.megabytes = megabytes;
        this.modelo = modelo;
        this.numeroDeSerie = "ME DA PEREZA";
        this.tasaDeTransmision = tasaDeTransmision;
        this.tecnologia = tecnologia;
        this.tipoDeInterface = tipoDeInterface;
        this.velocidadDeRotacion = velocidadDeRotacion;
    }
    public HardDisk(){
        this.fabricante = "UNKNOWN";
        this.megabytes = 0;
        this.modelo = "UNKNOWN";
        this.numeroDeSerie = "ME DA PEREZA";
        this.tasaDeTransmision = 0;
        this.tecnologia = "UNKNOWN";
        this.tipoDeInterface = "UNKNOWN";
        this.velocidadDeRotacion = 0;
    }
    
    public static HardDisk generateRandomValues(){
        Random r = new Random();
        HardDisk hd = new HardDisk();
        hd.fabricante = Constantes.FABRICANTES[r.nextInt(Constantes.FABRICANTES.length)];
        hd.megabytes = r.nextInt(Constantes.MAX_MB) + r.nextFloat();
        hd.modelo = Constantes.MODELOS[r.nextInt(Constantes.MODELOS.length)];
        hd.tasaDeTransmision = r.nextInt(Constantes.MAX_TASA_TRANSMISION);
        hd.tecnologia = Constantes.TECNOLOGIAS[r.nextInt(Constantes.TECNOLOGIAS.length)];
        hd.tipoDeInterface = Constantes.TIPOS_INTERFACE[r.nextInt(Constantes.TIPOS_INTERFACE.length)];
        hd.velocidadDeRotacion = r.nextInt(Constantes.MAX_VELOCIDAD_ROTACION);
        
        return hd;
    }

    public String[] toStringArray() {
        String[]data = new String[8];
        
        data[0] = this.fabricante ;
        data[1] = String.format("%.2f",this.megabytes);
        data[2] = this.modelo ;
        data[3] = this.numeroDeSerie;
        data[4] = String.valueOf(this.tasaDeTransmision);
        data[5] = this.tecnologia;
        data[6] = this.tipoDeInterface;
        data[7] = String.valueOf(this.velocidadDeRotacion);
        
        return data;
    }

    @Override
    public int compareTo(Object o) {
        HardDisk other = (HardDisk) o;
        return this.fabricante.compareTo(other.fabricante);
    }
    
    
}
