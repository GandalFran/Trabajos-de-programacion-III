/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab.blooping;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * @author franp
 */
public class Ejercicio3 {
    public static void run(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca numero: ");
        int n = sc.nextInt();
        
        System.out.println("Suma: " + IntStream.rangeClosed(1,n).sum());
        
        int p=1;
        for(int i=1;i<=n;i++){
            p*=i;
        }
        System.out.println("Producto: " + p);
    }

}
