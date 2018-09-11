/*
 * Copyright (C) 2017 Fran
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package GradesHandler;

import StudentServices.StudentServices;
import POJO.Student;
/**
 *
 * @author Fran
 */
public class GradesHandler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentServices studentServices = new StudentServices();
        Student [] studentsList = null;
        String [] dataTable = null;
        
        /*Lee los datos de teclado con Console, Scanner o por los argumentos 
          que se le pasan al programa segun corresponda y genera la tabla con
          los datos de los alumnos para imprimirlos en pantalla
          En vez de imprimir todo de una vez vamos de linea en linea para evitar
          que aparezcan comas en la tabla*/
        studentsList = studentServices.loadAllStudents(args);
        if(null != studentsList){
            dataTable = studentServices.writeAllStudents(studentsList);
            for(String line : dataTable){
                System.out.print(line);
            }
        }
        
    }
    
}
