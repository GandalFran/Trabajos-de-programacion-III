/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaexamenfinal;

import View.View;

/**
 *
 * @author franp
 */
public class PracticaExamenFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        View v = new View();
        String[]menus = new String[3];
        StringBuilder sb = new StringBuilder();
        
        sb.append("\nMENU PRINCIPAL:")
            .append("\n\t0)Nuevo paciente")
            .append("\n\t1)Nuevo medico")
            .append("\n\t2)Nuevo ingreso")
            .append("\n\t3)Exportar datos")
            .append("\n\t4)Ordenar pacientes")
            .append("\n\t5)Ordenar medicos")
            .append("\n\ts)salir")
            .append("\nSeleccione: ");
        menus[0] = sb.toString();
        
        sb.setLength(0);
        sb.append("\nORDENAR POR:")
            .append("\n\t1)DNI")
            .append("\n\t2)Apellidos y nombre")
            .append("\n\t3)Fecha ingreso")
            .append("\n\tv)volver")
            .append("\nSeleccione: ");
        menus[1] = sb.toString();
        
        sb.setLength(0);
        sb.append("\nORDENAR POR:")
            .append("\n\t1)Especialidad")
            .append("\n\t2)Apellidos y nombre")
            .append("\n\t3)Planta")
            .append("\n\tv)volver")
            .append("\nSeleccione: ");
        menus[2] = sb.toString();
        
        v.runMenu(menus);
    }
    
}
