/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab.blooping;

/**
 *
 * @author franp
 */
public class Ejercicio4 {
    public static void run(){
        int limite=12;
        for(int i=1; i<=limite; i++){
            System.out.println("");
            for(int j=1; j<=limite; j++){
                System.out.printf("\t%5dx%5d=%5d",i,j,i*j);
            }
        }
    }
}
