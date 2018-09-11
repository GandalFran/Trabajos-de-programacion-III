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
package StudentDao;

import Others.Constants;
import POJO.Student;
import java.util.Scanner;

/**
 *
 * @author Fran
 */
/*
    En esta implementacion de ReadStudentDataDao, leemos los datos con 
    la clase Scanner.
*/
public class ScannerStudentDataDao implements ReadStudentDataDao{
    @Override
     public Student[] readData(){
        Student [] list = new Student[Constants.NUM_STUDENTS];
        Scanner sc = new Scanner(System.in);
        Student tempStudent;

        for(int i=0; i<list.length; i++){
            tempStudent= new Student();
            System.out.print("\nAlumno " + (i+1) + "/" + Constants.NUM_STUDENTS + ": ");
            
            System.out.printf("\n\tNombre: ");
            tempStudent.setName(sc.nextLine());
            
            System.out.printf("\tParcial 1: ");
                do{
                    tempStudent.setParcial1(sc.nextFloat());
                    if(Constants.MIN_GRADE > tempStudent.getParcial1() || Constants.MAX_GRADE < tempStudent.getParcial1())
                        System.out.print("Introduzca una calificacion en el rango (" + Constants.MIN_GRADE + " - " + Constants.MAX_GRADE + "): ");
                }while(Constants.MIN_GRADE > tempStudent.getParcial1() || Constants.MAX_GRADE < tempStudent.getParcial1());
            
            System.out.printf("\tParcial 2: ");
                do{
                    tempStudent.setParcial2(sc.nextFloat());
                    if(Constants.MIN_GRADE > tempStudent.getParcial2() || Constants.MAX_GRADE < tempStudent.getParcial2())
                        System.out.print("Introduzca una calificacion en el rango (" + Constants.MIN_GRADE + " - " + Constants.MAX_GRADE + "): ");
                }while(Constants.MIN_GRADE > tempStudent.getParcial2() || Constants.MAX_GRADE < tempStudent.getParcial2());
            
            System.out.printf("\tFinal: ");
                do{
                    tempStudent.setFinalExam(sc.nextFloat());
                    if(Constants.MIN_GRADE > tempStudent.getFinalExam() || Constants.MAX_GRADE < tempStudent.getFinalExam())
                        System.out.print("Introduzca una calificacion en el rango (" + Constants.MIN_GRADE + " - " + Constants.MAX_GRADE + "): ");
                }while(Constants.MIN_GRADE > tempStudent.getFinalExam() || Constants.MAX_GRADE < tempStudent.getFinalExam());
            
            sc.nextLine(); 
            /*Vaciamos el buffer porque cuando introduzcamos el siguiente nombre,
            este se rellenara con el retorno de carro y no nos dejara introducir
            los datos deseados*/
            
            list[i]=tempStudent;
        }
        
        return list;
     }
}
