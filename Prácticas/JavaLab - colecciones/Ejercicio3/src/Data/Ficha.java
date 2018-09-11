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
public class Ficha implements Comparable, Serializable{

    private String nombre;
    private String apellidos;
    private String curso;
    private String DNI;
    private String grupoPracticas;
    private float calificacion;
    private String comentarios;

    public Ficha(String nombre, String apellidos, String curso, String DNI, String grupoPracticas, float calificacion, String comentarios) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
        this.DNI = DNI;
        this.grupoPracticas = grupoPracticas;
        this.calificacion = calificacion;
        this.comentarios = comentarios;
    }
    public Ficha( ) {
        this.nombre = "UNKNOWN";
        this.apellidos = "UNKNOWN";
        this.curso = "UNKNOWN";
        this.DNI = "UNKNOWN";
        this.grupoPracticas = "UNKNOWN";
        this.calificacion = -1f;
        this.comentarios = "UNKNOWN";
    }


    public static Ficha generateRandomValues(){
        Random r = new Random();
        Ficha f = new Ficha();
        f.nombre = Constantes.NAMES[r.nextInt(Constantes.NAMES.length)];
        f.apellidos = Constantes.SURNAMES[r.nextInt(Constantes.SURNAMES.length)];
        f.curso = Constantes.CURSOS[r.nextInt(Constantes.CURSOS.length)];
        f.DNI = Constantes.DNIS[r.nextInt(Constantes.DNIS.length)];
        f.grupoPracticas = Constantes.PRACTICAS[r.nextInt(Constantes.PRACTICAS.length)];
        f.calificacion = r.nextInt(Constantes.MAX_GRADE) + r.nextFloat();
        f.comentarios = Constantes.COMENTARIOS[r.nextInt(Constantes.COMENTARIOS.length)];
        
        return f;
    }

    public String[] toStringArray() {
        String[]data = new String[8];
        
        data[0] = this.nombre;
        data[1] = this.apellidos;
        data[2] = this.curso ;
        data[3] = this.DNI;
        data[4] = this.grupoPracticas;
        data[5] = String.format("%.2f",this.calificacion);
        data[6] = this.comentarios;
        
        return data;
    }

    @Override
    public int compareTo(Object o) {
        Ficha other = (Ficha) o;
        return this.DNI.compareTo(other.DNI);
    }

}
