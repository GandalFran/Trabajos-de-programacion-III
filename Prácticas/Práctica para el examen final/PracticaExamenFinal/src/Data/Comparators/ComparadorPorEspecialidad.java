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
public class ComparadorPorEspecialidad implements Comparator<Medico>{

    @Override
    public int compare(Medico o1, Medico o2) {
        return o1.getEspecialidad().compareTo(o2.getEspecialidad());
    }
    
}
