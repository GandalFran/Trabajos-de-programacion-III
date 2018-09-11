/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Others.Constantes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 *
 * @author franp
 */
public class Bill {
    private String nombre;
    private String razon_social;
    private String NIF;
    private float importe;
    private float tipo_de_IVA;
    private LocalDateTime fecha;
    private String concepto;

    public Bill(String nombre, String razon_social, String NIF, float importe, float tipo_de_IVA, String concepto) {
        this.nombre = nombre;
        this.razon_social = razon_social;
        this.NIF = NIF;
        this.importe = importe;
        this.tipo_de_IVA = tipo_de_IVA;
        this.fecha = LocalDateTime.now();
        this.concepto = concepto;
    }
    
    public Bill(){
        this.nombre = "UNKNOWN";
        this.razon_social = "UNKNOWN";
        this.NIF = "00000000";
        this.importe = 0;
        this.tipo_de_IVA = 0.21f;
        this.fecha = LocalDateTime.now();
        this.concepto = "UNKNOWN";
    }
    
    public static Bill generateRandomValues() {
        Random r = new Random();
        Bill b = new Bill();
        
        b.nombre = Constantes.NAMES[r.nextInt(Constantes.NAMES.length)];
        b.razon_social = Constantes.REASONS[r.nextInt(Constantes.REASONS.length)];
        b.NIF = Constantes.NIFS[r.nextInt(Constantes.NIFS.length)];
        b.importe = r.nextInt(Constantes.MAX_PRIZE) + r.nextFloat();
        b.tipo_de_IVA = r.nextFloat();
        b.concepto = Constantes.CONCEPTS[r.nextInt(Constantes.CONCEPTS.length)];
        
        return b;
    }

    public String[] toStringArray() {
        String[]data = new String[7];
        
        data[0] = this.NIF;
        data[1] = this.nombre;
        data[2] = this.razon_social;
        data[3] = this.concepto;
        data[4] = this.fecha.format(DateTimeFormatter.ofPattern("dd-M-uu HH:mm"));
        data[5] = String.format("%.2f", this.importe);
        data[6] = String.format("%.2f", this.tipo_de_IVA);
        
        return data;
    }
}
