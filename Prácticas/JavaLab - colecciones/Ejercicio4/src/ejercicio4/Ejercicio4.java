/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import View.View;

/**
 *
 * @author franp
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        View v = new View();
        
        v.runMenu("\nMENU:"
                + "\n\t1)Generar"
                + "\n\t2)Mostrar"
                + "\n\t3)Modificar"
                + "\n\ts)Salir"
                + "\nSeleccione: ");
    }
    
}
