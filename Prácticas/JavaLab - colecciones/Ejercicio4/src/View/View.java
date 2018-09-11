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
    
    public void runMenu(String menu){
        boolean salir = false;
        
        do{
            System.out.println(menu);
            String respuesta = sc.nextLine();
            
            switch(respuesta){
                case "1": generateRandomData(); break;
                case "2": showTable(); break;
                case "3": editTable(); break;
                case "s": salir = true; break;
                default : System.out.println("PUTO SUBNORMAL METE UN CARACTER CORRECTO");
            }
        }while(!salir);
    }
    
    
    private void generateRandomData(){
        c.generateRandomData();
    }
    
    private void showTable(){
        int[][]data = c.getTableData();
        String[]tipos = {"bj","bc","br","tj","tc","tr"};
        int[]total = {0,0,0,0,0,0};
        int index = 0;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<31; i++) sb.append("+--"); sb.append("+");
        String separador = "\n" + sb.toString();
        
        sb.setLength(0);
        for(int[]fil : data){
            sb.append(separador).append("\n");
            for(int value : fil){
                total[index] += value;
                sb.append(String.format("|%2d",value));
            }
            sb.append(String.format("|%s",tipos[index++]));
        }
        sb.append(separador);
        
        index = 0;
        sb.append("\n\n");
        sb.append(String.format("\nBlanco joven   : %4d",total[index++]));
        sb.append(String.format("\nBlanco crianza : %4d",total[index++]));
        sb.append(String.format("\nBlanco reserva : %4d",total[index++]));
        sb.append(String.format("\nTinto joven    : %4d",total[index++]));
        sb.append(String.format("\nTinto crianza  : %4d",total[index++]));
        sb.append(String.format("\nTinto reserva  : %4d",total[index++]));
        sb.append("\n");
       
        System.out.println(sb.toString());
    }
    
    private void editTable(){
        System.out.print("Introduzca dia del mes: ");
        int col = sc.nextInt(); sc.nextLine();
        System.out.print("Introduzca numero de vino: ");
        int fil = sc.nextInt(); sc.nextLine();
        System.out.print("Introduzca nuevo valor: ");
        int value = sc.nextInt(); sc.nextLine();
        
        if(col<0 || fil<0 || col>= c.getTableData()[0].length || fil>= c.getTableData().length || value<0 || value>100)
            System.out.println("PUTO SUBNORMAL; METE VALORES VALIDOS");
        else
            c.editValue(fil,col,value);
    }
    
}
