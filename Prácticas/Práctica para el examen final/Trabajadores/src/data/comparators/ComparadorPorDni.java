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
public class ComparadorPorDni implements Comparator<Trabajador>{

    public ComparadorPorDni() {
    }

    @Override
    public int compare(Trabajador o1, Trabajador o2) {
        return Integer.compare(o1.getDni(),o2.getDni());
    }
    
}
