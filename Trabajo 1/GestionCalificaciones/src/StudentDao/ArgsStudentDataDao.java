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

import POJO.Student;
import Others.Constants;
import java.util.Scanner;

/**
 *
 * @author Fran
 */
/*
    Esta implementacion de readStudentDataDao toma los datos del vector de String[]args
    el cual recibe y clasifica en los distintos campos de Student.
    En el caso de no recibir la cantidad de argumentos requerida, lo notifica y
    retorna un valor null.
    ----------------------------------------------------------------------------
    Forma correcta de dar los agrumentos:
        NombreA1 Parcial1A1 Parcial2A1 FinalA1 ... Parcial2A10 FinalA10
        con A1 = Alumno 1 y A10 = Alumno 10
*/
public abstract class ArgsStudentDataDao implements ReadStudentDataDao{
    
    public static Student[] readData(String [] args){
        Student [] list = new Student[Constants.NUM_STUDENTS];
        Student tempStudent=null;
        Scanner sc = new Scanner(System.in);
        
        for(int i=0, k=0;i<args.length;i+=4,k++){
            for(int j=i+1;j<(i+4);j++){
                if(Constants.MIN_GRADE > Float.parseFloat(args[j]) || Constants.MAX_GRADE < Float.parseFloat(args[j])){
                    System.err.println("ERROR: La calificacion " + args[j] + " en la posicion " + (1+j) + " no se encuentraen el rango (" + Constants.MIN_GRADE + " - " + Constants.MAX_GRADE + ").");
                    System.err.print("Inroduzca una nueva: ");
                    args[j]=sc.nextFloat() + "";
                    sc.nextLine();  //Vaciar el buffer
                    j--;    //Para volver a comprobar que la calificacion es correcta
                }
            }
            
            tempStudent = new Student(args[i],      //Nombre
                    Float.parseFloat(args[i+1]),    //Parcial 1
                    Float.parseFloat(args[i+2]),    //Parcial 2
                    Float.parseFloat(args[i+3]) );  //Final
            
            list[k]=tempStudent;
        }
        
        return list;
    }
}
