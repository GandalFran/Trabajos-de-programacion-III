/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.Almacen;
import Model.Constantes;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                    leerTeclado();
                    break;
                case(2):
                    leerAleatorio();
                    break;
                case(3):
                    sacarResultadosPantalla();
                    break;
                case(4):
                    sacarResultadosFichero();
                    break;
                case(5):
                    salir=true;
                    break;
            }
        }while(salir == false);
    }
    
    private void leerTeclado(){
        float[][]precios = new float [Constantes.NUM_ALMACENES][Constantes.NUM_PRODUCTOS];
        int[][]ventas = new int [Constantes.NUM_ALMACENES][Constantes.NUM_PRODUCTOS];
        
        for(int i=0; i<Constantes.NUM_ALMACENES; i++){
            System.out.println("Almacen " + (i+1) + ": ");
            for(int j=0; j<Constantes.NUM_PRODUCTOS; j++){
                System.out.print("\n\tProducto " + (j+1) + ": ");
                System.out.println("\n\t\tPrecio: ");
                precios[i][j]=sc.nextFloat();
                System.out.println("\n\t\tVentas: ");
                ventas[i][j]=sc.nextInt();
            }
        }
        
        c.importDataFromKeyboard(precios,ventas);
    }
    
    private void leerAleatorio(){
        c.setRandomValues();
    }
    
    private void sacarResultadosPantalla(){
        String toPrint = c.getDataTable();
        System.out.println(toPrint);
    }
    
    private void sacarResultadosFichero(){
        String ruta = System.getProperty("user.home") + "/Desktop/tabla.html";
        int resultado = c.exportDataHTML(ruta);
        
        if(-1 == resultado){
            System.out.println("ERROR: los datos no puedieron ser guardados en " + ruta + ".");
        }else{
            System.out.println("Los datos se exportaron satisfactoriamente");
        }
    }

    
}