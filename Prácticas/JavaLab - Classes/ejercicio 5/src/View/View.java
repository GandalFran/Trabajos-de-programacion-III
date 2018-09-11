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
    
    private Controller c = new Controller();
    private Scanner sc = new Scanner(System.in);
    
    public void runMenu(String toPrint){
        boolean salir = false;
        String resp = null;
        
        do{
            System.out.println(toPrint);
            resp = sc.nextLine();
            
            switch(resp){
                case "1" :
                    cargarDatos();
                break;
                case "2" :
                    mostrarDatos();
                break;
                case "3" :
                    salir = true;
                break;
                default:
                    System.out.println("Introduce un valor correcto subnormal");
            }
        }while( !salir );
    }
    
    
    private void cargarDatos(){
        String ruta = System.getProperty("user.home") +  "/Desktop/datos.txt";
        c.loadDataFromFile(ruta);
    }
    
    private void mostrarDatos(){
        String toPrint = c.getDataTable();
        System.out.println(toPrint);
    }
}
