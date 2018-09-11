/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import View.View;

/**
 *
 * @author franp
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        View v = new View();
        
        v.runMenu("\nMENU:"
                + "\n\t1) Dar valores"
                + "\n\t2) Importar"
                + "\n\t3) Ordenar"
                + "\n\t4) Ver listado"
                + "\n\t5) Exportar"
                + "\n\ts) Salir"
                + "\nSeleccione: ");
    }
    
}
