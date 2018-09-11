/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.comparators;

import data.Trabajador;
import java.util.Comparator;

/**
 *
 * @author franp
 */
public class ComparadorPorApellidosNombre implements Comparator<Trabajador> {
    @Override
    public int compare(Trabajador o1, Trabajador o2) {
        if(o1.getApellidos().equalsIgnoreCase(o2.getApellidos()))
            return o1.getNombre().compareToIgnoreCase(o2.getNombre());
        else
            return o1.getApellidos().compareToIgnoreCase(o2.getApellidos());
    }
    
}
