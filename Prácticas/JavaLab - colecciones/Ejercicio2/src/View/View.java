package View;

import Controller.Controller;
import Others.Constantes;
import java.io.IOException;
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
                case "2": importData(); break;
                case "3": sortData(); break;
                case "4": showList(); break;
                case "5": exportData(); break;
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
            String separador = String.format(Constantes.HDD_FORMAT," "," "," "," "," "," "," "," ").replace(" ", "-").replace("|","+");

            sb.append("\n").append(separador);
            sb.append("\n").append(String.format(Constantes.HDD_FORMAT,"FABRICANTE","MB","MODELO","NUMERO_SERIE","TRANSMISION","TECNOLOGIA","INTERFACE","ROTACION"));
            for(String[]hd : data)
                sb.append("\n").append(separador).append("\n").append(String.format(Constantes.HDD_FORMAT,hd[0],hd[1],hd[2],hd[3],hd[4],hd[5],hd[6],hd[7]));
            sb.append("\n").append(separador).append("\n");

            System.out.println(sb.toString());
        }
    }

    private void sortData() {
        c.sortData();
    }
    
    private void importData() {
        try{
            c.importData();
        }catch(IOException e){
            System.out.println("ERROR: data couldn't be imported");
            return;
        }
        System.out.println("Succes at data importing");
    }

    private void exportData() {
         try{
            c.exportData();
        }catch(IOException e){
            System.out.println("ERROR: data couldn't be exported");
            return;
        }
         System.out.println("Succes at data exporting");
    }

    
}
