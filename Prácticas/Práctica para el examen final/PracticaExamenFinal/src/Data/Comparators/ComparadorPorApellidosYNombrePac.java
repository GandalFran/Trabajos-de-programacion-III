/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Comparators;

import Data.Paciente;
import java.util.Comparator;

/**
 *
 * @author franp
 */
public class ComparadorPorApellidosYNombrePac implements Comparator<Paciente>{

    @Override
    public int compare(Paciente o1, Paciente o2) {
        if(o1.getApe1().equalsIgnoreCase(o2.getApe1())){
            if(o1.getApe2().equalsIgnoreCase(o2.getApe2())){
                return o1.getNombre().compareToIgnoreCase(o2.getNombre());
            }else
                return o1.getApe2().compareToIgnoreCase(o2.getApe2());
        }else
            return o1.getApe1().compareToIgnoreCase(o2.getApe1());
    }
    
}
