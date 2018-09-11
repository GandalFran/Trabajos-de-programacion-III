/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab.blooping;

import java.time.LocalDate;

/**
 *
 * @author franp
 */
public class Ejercicio7 {
    
    public static void run(){
        LocalDate ld = LocalDate.now();
        
        int i=1;
        while(i<=20){
            if(ld.isLeapYear()){
                i++;
                System.out.println(ld.getYear());
            }
            ld=ld.plusYears(1);
        }
    
    }
}
