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
import java.io.Console;

/**
 *
 * @author Fran
 */
/*
    Esta implementacion de readDataDao toma los datos de la terminal.
    En el caso de no poder acceder a la consola, se notifica y se devuelve una
    lista a null;
*/

public class ConsoleStudentDataDao implements ReadStudentDataDao{

    @Override
    public Student[] readData(){
        Student [] list = new Student[Constants.NUM_STUDENTS];
        Console con = System.console();
        Student tempStudent = null;
        float tempFloat;
        
        if(null == con){
            System.err.println("ERROR: No se pudo acceder a la consola del sistema");
            return null;
        }
        
        /*  Una iteracion para meter los datos de cada alumno.
            Se va metiendo todo en tempStudent y se añade al vector de alumnos al final.
            Se usa una variable temporal de tipo float como intermediario para hacer mas
            legible el codigo.*/
        for(int i=0; i<Constants.NUM_STUDENTS; i++){
            tempStudent= new Student();
            con.printf("%nAlumno %d/%d: ", (i+1), Constants.NUM_STUDENTS);
            
            tempStudent.setName(con.readLine("\n\tNombre: "));
            
            con.printf("\tParcial 1: ");
                do{
                    tempFloat=Float.parseFloat(con.readLine());
                    if(Constants.MIN_GRADE > tempFloat || Constants.MAX_GRADE < tempFloat)
                        con.printf("\tIntroduzca una calificacion en el rango (" + Constants.MIN_GRADE + " - " + Constants.MAX_GRADE + "): ");
                }while(Constants.MIN_GRADE > tempFloat || Constants.MAX_GRADE < tempFloat);
            tempStudent.setParcial1(tempFloat);
            
            con.printf("\tParcial 2: ");
                do{
                    tempFloat=Float.parseFloat(con.readLine());
                    if(Constants.MIN_GRADE > tempFloat || Constants.MAX_GRADE < tempFloat)
                        con.printf("\tIntroduzca una calificacion en el rango (" + Constants.MIN_GRADE + " - " + Constants.MAX_GRADE + "): ");
                }while(Constants.MIN_GRADE > tempFloat || Constants.MAX_GRADE < tempFloat);
            tempStudent.setParcial2(tempFloat);
            
            con.printf("\tFinal: ");
                do{
                    tempFloat=Float.parseFloat(con.readLine());
                    if(Constants.MIN_GRADE > tempFloat || Constants.MAX_GRADE < tempFloat)
                        con.printf("\tIntroduzca una calificacion en el rango (" + Constants.MIN_GRADE + " - " + Constants.MAX_GRADE + "): ");
                }while(Constants.MIN_GRADE > tempFloat || Constants.MAX_GRADE < tempFloat);
            tempStudent.setFinalExam(tempFloat);
            
            list[i]=tempStudent;
        }
        
        return list;
    }
}
