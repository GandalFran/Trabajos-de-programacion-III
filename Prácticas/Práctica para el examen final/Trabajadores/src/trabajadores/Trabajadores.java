/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajadores;

import View.View;

/**
 *
 * @author franp
 */
public class Trabajadores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        View v = new View();
        v.runMenu("MENU"
                + "\n\t1)Añadir trabajador"
                + "\n\t2)Editar trabajador"
                + "\n\t3)Mostrar trabajador"
                + "\n\t4)Mostrar tabla"
                + "\n\t5)Exportar datos"
                + "\n\t6)Generar trabajadores aleatorios"
                + "\n\t7)Eliminar trabajador"
                + "\n\ts)salir");
    }
    
}
