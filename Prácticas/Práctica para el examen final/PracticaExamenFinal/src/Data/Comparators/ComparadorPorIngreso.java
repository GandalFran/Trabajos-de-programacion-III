/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Comparators;

import Data.Paciente;
import java.time.LocalDateTime;
import java.util.Comparator;

/**
 *
 * @author franp
 */
public class ComparadorPorIngreso implements Comparator<Paciente>{

    @Override
    public int compare(Paciente o1, Paciente o2) {
        if(o1.getListaIngresos().isEmpty())
            return 1;
        else if (o2.getListaIngresos().isEmpty())
            return -1;
        else{
            LocalDateTime l1 = o1.getListaIngresos().get(0).getFecha();
            LocalDateTime l2 = o2.getListaIngresos().get(0).getFecha();
            
            return l1.compareTo(l2);
        }
    }
    
}
