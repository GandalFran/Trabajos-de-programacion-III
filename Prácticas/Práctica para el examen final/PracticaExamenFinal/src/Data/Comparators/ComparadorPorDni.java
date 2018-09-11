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
public class ComparadorPorDni implements Comparator<Paciente>{

    @Override
    public int compare(Paciente o1, Paciente o2) {
        return Integer.compare(o1.getDni(),o2.getDni());
    }
    
}
