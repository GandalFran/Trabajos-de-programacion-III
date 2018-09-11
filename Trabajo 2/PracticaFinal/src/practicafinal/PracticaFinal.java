/*
 * Copyright (C) 2017 franp
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package practicafinal;

import View.View;


/**
 * Clase principal.
 * @author franp
 */
public class PracticaFinal {
    
    public static void main(String[] args) {
        String[]menus = new String[6];
        StringBuilder sb = new StringBuilder();
        
        System.err.println("ATENCION: Con el fin de facilitar la correccion, codigo esta documentado. SE PUEDE GENERAR EL JAVADOC");
     
        //Creamos el menu principal
        sb.append("\nMENU PRINCIPAL:")
            .append("\n\t1)Archivos")
            .append("\n\t2)Clientes")
            .append("\n\t3)Resultados")
            .append("\n\t4)Listados")
            .append("\n\t5)Ventas")
            .append("\n\ts)Salir")
            .append("\nSeleccione: ");
        menus[0]=sb.toString();
        
        //Creamos el menu de archivos
        sb.setLength(0);
        sb.append("\nMENU ARCHIVOS:")
            .append("\n\t1)Exportar productos a encolumnado")
            .append("\n\t2)Exportar productos a HTML")
            .append("\n\tv)Volver al menu principal")
            .append("\nSeleccione: ");
        menus[1]=sb.toString();
        
        //Creamos el menu de clientes
        sb.setLength(0);
        sb.append("\nMENU CLIENTES:")
            .append("\n\t1)Añadir cliente")
            .append("\n\t2)Modificar cliente")
            .append("\n\tv)Volver al menu principal")
            .append("\nSeleccione: ");
        menus[2]=sb.toString();
        
        //Creamos el menu de resultados
        sb.setLength(0);
        sb.append("\nMENU RESULTADOS:")
            .append("\n\t1)Obtener importe total de ventas")
            .append("\n\t2)Obtener importe total de un cliente")
            .append("\n\t3)Calcular valor de las existencias del almacen")
            .append("\n\tv)Volver al menu principal")
            .append("\nSeleccione: ");
        menus[3]=sb.toString();
        
        //Creamos el menu de listados
        sb.setLength(0);
        sb.append("\nMENU LISTADOS:")
            .append("\n\t1)Imprimir productos en orden alfabetico")
            .append("\n\t2)Imprimir productos en orden de iva y precio")
            .append("\n\t3)imprimir clientes segun apellidos y nombre")
            .append("\n\t4)imprimir clientes segun dni")
            .append("\n\tv)Volver al menu principal")
            .append("\nSeleccione: ");
        menus[4]=sb.toString();
        
        //Creamos el menu de listados
        sb.setLength(0);
        sb.append("\nMENU VENTAS:")
            .append("\n\t1)Realizar compra con ticket")
            .append("\n\t2)Realizar compra con factura")
            .append("\n\tv)Volver al menu principal")
            .append("\nSeleccione: ");
        menus[5]=sb.toString();
        
        
        //Creamos vista y llamamos a runMenu
        View v = new View();
        v.runMenu(menus);
    }
    
}
