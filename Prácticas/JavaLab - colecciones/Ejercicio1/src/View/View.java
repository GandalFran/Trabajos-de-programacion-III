package View;

import Controller.Controller;
import Others.Constantes;
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author franp
 */
public class View {
    private Scanner sc = new Scanner(System.in);
    private Controller c = new Controller();
    
    public void runMenu(String menu) {
        boolean salir = false;
        String rsp; 
        
        while(!salir){
            System.out.print(menu);
            rsp = sc.nextLine();
        
            switch(rsp){
                case "1": generateValues(); break;
                case "2": showList(); break;
                case "s": salir = true; break;
                default: System.out.println("SUBNORMAL NO ES MUY DIFICIL PUSLAR 1, 2 o S"); break;
            }
        }
    }
    
    private void generateValues() {
        c.generateRandomValues();
    }
    
    private void showList() {
        String[][]data = c.getAllBillData();
        
        if(null != data){
            StringBuilder sb = new StringBuilder();
            String separador = String.format(Constantes.BILL_FORMAT," "," "," "," "," "," "," ").replace(" ", "-").replace("|","+");

            sb.append("\n").append(separador);
            sb.append("\n").append(String.format(Constantes.BILL_FORMAT,"NIF","NOMBRE","RAZON_SOCIAL","CONCEPTO","FECHA","IMPORTE","IVA"));
            for(String[]b : data)
                sb.append("\n").append(separador).append("\n").append(String.format(Constantes.BILL_FORMAT,b[0],b[1],b[2],b[3],b[4],b[5],b[6]));
            sb.append("\n").append(separador).append("\n");

            System.out.println(sb.toString());
        }
    }

    
}
