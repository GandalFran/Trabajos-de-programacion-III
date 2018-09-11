/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import java.util.Scanner;

/**
 *
 * @author franp
 */
public class View {
    
    private final Controller c = new Controller();
    private final Scanner sc = new Scanner(System.in);
    
    public void runMenu(String menuText){
        boolean salir = false;
        
        do{
            System.out.println(menuText);
            int seleccion = sc.nextInt();
            
            switch(seleccion){
            
                case(1):
                    pedirNumeros();
                    break;
                case(2):
                    c.sumarNumeros();
                    break;
                case(3):
                    sacarResultados();
                    break;
                case(4):
                    salir=true;
                    break;
            }
        }while(salir == false);
    }
    
    
    private void pedirNumeros(){
        System.out.println("Introduzca numero 1: ");
        int num1=sc.nextInt();
        System.out.println("Introduzca numero 2: ");
        int num2=sc.nextInt();
        c.setNum1(num1);
        c.setNum2(num2);
    }
    
    private void sacarResultados(){
        System.out.println("Numero 1: " + c.getNum1());
        System.out.println("Numero 2: " + c.getNum2());
        System.out.println("Resultado: " + c.getResult());
    }
    
}
