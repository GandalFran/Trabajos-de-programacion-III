/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

import View.View;

/**
 *
 * @author franp
 */
public class JavaApplication10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        View v = new View();
        
        v.runMenu("MENU"
                + "\n\t1)leer de teclado"
                + "\n\t2)generar datos aleatorios"
                + "\n\t3)sacar resultados por pantalla"
                + "\n\t4)sacar resultados por fichero"
                + "\n\t5)salir"
                + "\nSeleccione: ");
    }
    
}
