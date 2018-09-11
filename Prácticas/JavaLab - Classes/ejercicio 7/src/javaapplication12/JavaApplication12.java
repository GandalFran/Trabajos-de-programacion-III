/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

import View.View;

/**
 *
 * @author franp
 */
public class JavaApplication12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        View v = new View();
        
        v.runMenu("MENU"
                + "\n\t1)generar lista de alumnos"
                + "\n\t2)mostrar tabla de alumnos"
                + "\n\t3)mostrar lista de alumnos con poca asistencia"
                + "\n\t4)exportar datos"
                + "\n\t5)salir"
                + "\nSeleccione: ");
    }
    
}
