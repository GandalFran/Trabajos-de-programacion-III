/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import View.View;

/**
 *
 * @author franp
 */
public class JavaApplication9 {

    /**
     * @param args the command line arguments
     */ 
    public static void main(String[] args) {
        View v = new View();
        
        v.runMenu(String.format("\nMENU:"
                + "\n\t1)Meter numeros"
                + "\n\t2)Sumar numeros"
                + "\n\t3)Imprimir resultados"
                + "\n\t4)Salir"
                + "\nSeleccione: "));
    }
    
}
