/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Comparators;

import Data.Medico;
import java.util.Comparator;

/**
 *
 * @author franp
 */
public class ComparadorPorApellidosYNombreMed implements Comparator<Medico>{

    @Override
    public int compare(Medico o1, Medico o2) {
        if(o1.getApellidos().equalsIgnoreCase(o2.getApellidos()))
            return o1.getNombre().compareToIgnoreCase(o2.getNombre());
        else
            return o1.getApellidos().compareTo(o1.getApellidos());
    }
    
}
