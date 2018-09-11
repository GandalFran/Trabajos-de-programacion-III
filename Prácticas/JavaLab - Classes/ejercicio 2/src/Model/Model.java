/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franp
 */
public class Model {
    private List <Almacen> almacenes = null;
    
    public List<String> generateHTMLDataTable(){
        List <String> lista = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
         //Cabecera HTML
        lista.add("<!DOCTYPE html><HTML><HEAD><meta charset=\"UTF_8\">\n");
        lista.add("<HEAD><H1>Precios</H1></HEAD>");
        if( null == this.almacenes ||this.almacenes.isEmpty()){
                lista.add("<strong>No se tienen datos todavia<strong>\n");
        }else{
            //TABLA 1
            lista.add("<BODY>");
            lista.add("<TABLE BORDER = 1>");
                sb.append("<TR>");
                sb.append("<TD><strong>Almacen<strong></TD>");
                for(int i=0; i<Constantes.NUM_PRODUCTOS; i++)
                    sb.append("  <TD><strong>Producto " + (i+1) + "</strong></TD>");
                sb.append("</TR>");
            lista.add(sb.toString());

            //Añadir datos
            int i=1;
            for(Almacen a : this.almacenes){
                    sb.setLength(0);    //Vaciar stringbuilder
                    sb.append("<TR>");
                    sb.append(" <TD>" + (i++) + "</TD>");
                    for(float f: a.getPrecios())
                       sb.append(String.format("<TD>%5.2f</TD>",f));
                    sb.append("</TR>");
                lista.add(sb.toString());
            }
            lista.add("</TABLE>\n");


            //TABLA 2
            sb.setLength(0);
            lista.add("<H1>Ventas</H1>");
            lista.add("<TABLE BORDER = 1>");
                sb.append("<TR>");
                sb.append("<TD><strong>Almacen<strong></TD>");
                for( i=0; i<Constantes.NUM_PRODUCTOS; i++)
                    sb.append("  <TD><strong>Producto " + (i+1) + "</strong></TD>");
                sb.append("</TR>");
            lista.add(sb.toString());

            //Añadir datos
            i=1;
            for(Almacen a : this.almacenes){
                    sb.setLength(0);    //Vaciar stringbuilder
                    sb.append("<TR>");
                    sb.append(" <TD>" + (i++) + "</TD>");
                    for(int v: a.getVentas())
                        sb.append(String.format("<TD>%d</TD>",v));
                    sb.append("</TR>");
                lista.add(sb.toString());
            }
            lista.add("</TABLE>\n");

            //TABLA 3
            sb.setLength(0);
            lista.add("<H1>Beneficios</H1>");
            lista.add("<TABLE BORDER = 1>");
                sb.append("<TR>");
                for(i=0; i<Constantes.NUM_ALMACENES; i++)
                    sb.append("  <TD><strong>Almacen " + (i+1) + "</strong></TD>");
                sb.append("</TR>");
            lista.add(sb.toString());

            sb.setLength(0);
            sb.append("<TR>");
            for(Almacen a : this.almacenes){
                sb.append(String.format(" <TD>%5.2f</TD>",a.calcularBeneficios()));
            }
            sb.append("</TR>");
            lista.add(sb.toString());
            lista.add("</TABLE>\n");
        }
        
        //Cerrar archivo html
        lista.add("</BODY></HTML>");
        
        return lista;
    }
    public String generateStringDatatable(){
    
        StringBuilder sb = new StringBuilder();
        
        sb.append("PRECIOS");
        sb.append(String.format("\n|%10s","Almacenes"));
        for(int i=0; i<Constantes.NUM_PRODUCTOS; i++){
               sb.append(String.format("|%9s%1d","Producto",i+1));
        }
        int i=1;
        for(Almacen a : this.almacenes){
           sb.append(String.format("|\n|%10d",i++));
           for(float precio : a.getPrecios())
               sb.append(String.format("|%10.2f",precio));
        }
        sb.append("|\n");
        
        sb.append("VENTAS");
        sb.append(String.format("\n|%10s","Almacenes"));
        for(i=0; i<Constantes.NUM_PRODUCTOS; i++){
               sb.append(String.format("|%9s%1d","Procuto",i+1));
        }
        i=1;
        for(Almacen a : this.almacenes){
           sb.append(String.format("|\n|%10d",i++));
           for(int venta : a.getVentas())
               sb.append(String.format("|%10d",venta));
        }
        sb.append("|\n");
        
        
        sb.append("BENEFICIOS\n");
        for(i=0; i<Constantes.NUM_ALMACENES; i++){
               sb.append(String.format("|%9s%1d","Almacen",i+1));
        }
        sb.append("|\n");
        for(Almacen a : this.almacenes){
           sb.append(String.format("|%10.2f",a.calcularBeneficios()));
        }
        sb.append("|\n");
        
        return sb.toString();
    
    }
    
    public void saveDataFromKeyBoard(float[][]precios,int[][]ventas){
        if( null == this.almacenes ){
            this.almacenes = new ArrayList<>();
        }else if( !this.almacenes.isEmpty()){
            this.almacenes.clear();
        }
        
        Almacen a = null;
        for(int i=0; i<Constantes.NUM_ALMACENES; i++){
            a = new Almacen();
            a.setPrecios(precios[i]);
            a.setVentas(ventas[i]);
            this.almacenes.add(a);
        }
    }
    public void generateRandomValues(){
        if( null == this.almacenes ){
            this.almacenes = new ArrayList<>();
        }else if( !this.almacenes.isEmpty()){
            this.almacenes.clear();
        }
        
        Almacen a = null;
        for(int i=0; i<Constantes.NUM_ALMACENES; i++){
            a = new Almacen();
            Almacen.generateRandomValues(a);
            this.almacenes.add(a);
        }
    }
    
}
