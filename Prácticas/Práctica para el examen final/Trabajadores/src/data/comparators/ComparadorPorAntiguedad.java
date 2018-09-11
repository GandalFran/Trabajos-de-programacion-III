/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.comparators;

import data.Trabajador;
import java.time.LocalDateTime;
import java.util.Comparator;

/**
 *
 * @author franp
 */
public class ComparadorPorAntiguedad implements Comparator<Trabajador>{

    @Override
    public int compare(Trabajador o1, Trabajador o2) {
        LocalDateTime l1 = o1.getContrato();
        LocalDateTime l2 = o2.getContrato();
        
        return l1.compareTo(l2);
    }
    
}
