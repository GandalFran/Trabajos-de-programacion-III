/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg5;

import View.View;

/**
 *
 * @author franp
 */
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        View v = new View();
        
        v.runMenu("MENU:"
                + "\n\t1)Leer datos"
                + "\n\t2)generar tabla"
                + "\n\t3)salir"
                + "\nSeleccione: ");
    }
    
}
