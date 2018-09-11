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
public class Ejercicio5 {
    public static void run(){
        int i=2;
        
        while(true){
            if(isPrime(i))
                System.out.println(i);
            i++;
        }
    }
    
    private static boolean isPrime(int i){
        
        for(int j=2; j<=Math.sqrt(i); j++){
            if (i%j==0){
                return false;
            }
        }
        return true;
                
    }
}
