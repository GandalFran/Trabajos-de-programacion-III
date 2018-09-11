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
package StudentServices;

import Others.Constants;
import StudentDao.*;
import POJO.Student;


/**
 *
 * @author Fran
 */
public class StudentServices {
    /*Se le pasan los argumentos del programa porque una de las opciones es que
      tome los datos de dicho vector*/
    public Student[] loadAllStudents(String[]args){
        ReadStudentDataDao studentDataReader;
        
        if(args.length==(Constants.NUM_STUDENTS*4)){  //NUM_STUDENTS*4 porque se recibe el nombre y 4 notas 
            return ArgsStudentDataDao.readData(args);
        }else if(args.length>0){
            System.err.println("ERROR: No se recibio el numero correcto de argumentos");
            System.err.println("Recibidos: " + args.length + " de " + Constants.NUM_STUDENTS*4 + " necesarios.");
            System.err.println("Procediendo a introduccion de datos manual.");
        }
        
        if(null != System.console()){
            studentDataReader = new ConsoleStudentDataDao();
        }else{
            studentDataReader= new ScannerStudentDataDao();
        }
        return studentDataReader.readData();
    }
    
    public String[] writeAllStudents(Student[]students){
        //una fila por alumno + 3 lineas separadoras + cabecera
        String[]lista = new String[students.length + 4]; 
        
        lista[0]=String.format("%n%49s"," ").replace(" ", "-");
        lista[1]=String.format("%n|%-15s|%-9s|%-9s|%-5s|%-5s|","ALUMNO","PARCIAL 1","PARCIAL 2", "FINAL","MEDIA");
        lista[2]=String.format("%n%49s"," ").replace(" ", "-");
        int i=3;
        for(Student s : students){
            lista[i++]=(String.format("%n|%-15s|%9.1f|%9.1f|%5.1f|%5.1f|"
                            ,s.getName(),s.getParcial1(),s.getParcial2(),s.getFinalExam(),
                            getAverage(s.getParcial1(),s.getParcial2(),s.getFinalExam())));
        }
        lista[i]=String.format("%n%49s%n"," ").replace(" ", "-");
        
        return lista;
    }
    
    private float getAverage(float p1, float p2, float f){
        return ((p1+p2+f)/3);
    }
}
