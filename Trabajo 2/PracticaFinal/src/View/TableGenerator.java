/*
 * Copyright (C) 2017 franp
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package View;

import Otros.Constantes;

/**
 *Para generar tablas de productos, clientes, tickets y facturas.
 * @author franp
 */
public class TableGenerator {
    
   /**
     * Genera una tabla de productos
     * @param productos informacion a imprimir en la tabla sobre los productos
     * @see Data.Producto#toStringArray() 
     * @return String con tabla que contiene todos los datos suministrados en String[][]productos
     */
    public String generarTablaProductos(String[][]productos){
        StringBuilder sb = new StringBuilder();
        String separador = String.format(Constantes.FORMATO_PRODUCTOS_TABLAS," "," "," "," ").replace(" ","-").replace("|","+");
            
        sb.append("\n").append(separador).append("\n")
            .append(String.format("|%28s%-20s%15s|"," ","PRODUCTOS"," ")).append("\n").append(separador).append("\n")
            .append(String.format(Constantes.FORMATO_PRODUCTOS_TABLAS,"Nombre","Precio","Iva","Stock")).append("\n").append(separador).append("\n");
        
        for(String[] f : productos){
                sb.append(String.format(Constantes.FORMATO_PRODUCTOS_TABLAS,f[0],f[1],f[2],f[3])).append("\n").append(separador).append("\n");
        }
            
        return sb.toString();
    }
    
   /**
     * Genera una tabla de clientes
     * @param clientes informacion a imprimir en la tabla sobre los clientes
     * @see Data.Cliente#toStringArray() 
     * @return String con tabla que contiene todos los datos suministrados en String[][]clientes
     */
    public String generarTablaClientes(String[][]clientes){
        StringBuilder sb = new StringBuilder();
        String separador = String.format(Constantes.FORMATO_CLIENTES_TABLAS," "," "," "," "," ").replace(" ","-").replace("|","+");
            
        sb.append("\n").append(separador).append("\n")
            .append(String.format("|%35s%s%38s|"," ","CLIENTES"," ")).append("\n").append(separador).append("\n")
            .append(String.format(Constantes.FORMATO_CLIENTES_TABLAS,"DNI","Apellidos y nombre","Direccion","Estado")).append("\n").append(separador).append("\n");
        
        for(String[] f : clientes){
                sb.append(String.format(Constantes.FORMATO_CLIENTES,f[0],f[2],f[1],f[3],f[4])).append("\n").append(separador).append("\n");
        }
            
        return sb.toString();
    }
    
   /**
     * Genera un ticket para ser imprimido
     * @param ticketInfo informacion sobre el ticket
     * @see Data.Ticket#toStringArray() 
     * @param infoProductos informacion sobre los productos que componen el ticket
     * @return String con una factura generada
     */
    public String generarTicket(String[]ticketInfo,String[][]infoProductos){
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append("FACTURA SIMPLIFICADA")
            .append("\n").append(ticketInfo[2])
            .append("\n").append("N.FACT.O:").append(ticketInfo[0])
            .append("\n");
        
        sb.append(generarCuerpoTicket(infoProductos));

        return sb.toString();
    }
    
    /**
     * Genera un factura para ser imprimida
     * @param facturaInfo informacion sobre la factura
     * @see Data.Factura#toStringArray() 
     * @param clienteInfo informacion del ciente del cual es la factura
     * @param infoProductos informacion sobre los productos que componen la factura
     * @return String con una factura generada
     */
    public String generarFactura(String[]facturaInfo,String[]clienteInfo,String[][]infoProductos){
        StringBuilder sb = new StringBuilder();
        
        sb.append("\n").append("FACTURA ORDINARIA")
            .append("\n").append(facturaInfo[2])
            .append("\n").append("N.FACT.O:").append(facturaInfo[0])
            .append("\n\n").append("Cliente: ").append(clienteInfo[1]).append(" ").append(clienteInfo[2]).append("\t").append(clienteInfo[0])
            .append("\n").append(clienteInfo[3])
            .append("\n");
        
        sb.append(generarCuerpoTicket(infoProductos));

        return sb.toString();
    }
    
    /**
     * Genera el cuerpo de un ticket o factura para ser imprimido
     * @param infoProductos matriz donde cada fila contiene la informacion de un producto
     * @see Data.Cliente#toStringArray() 
     * @return String cuerpo del ticket a imprimir
     */
    private String generarCuerpoTicket(String[][]infoProductos){
        StringBuilder sb = new StringBuilder();
        float[]ivaAcumulado = {0,0,0};
        float precioAcumulado=0, precio, iva;
        int cantidad;
        
        sb.append("\n").append("*****PVP IVA INCLUIDO*****")
            .append("\n");
        
        for(String[]p : infoProductos){
            //Transformaciones
            try{
                precio = Float.parseFloat(p[1]);
                iva = Float.parseFloat(p[2]);
                cantidad = Integer.parseInt(p[3]);
            }catch(NumberFormatException e){
                return "\nERROR: no valid ticket data\n";
            }
            //Calculos
            switch (p[2]) {
                case "0.04": ivaAcumulado[0] += precio*cantidad; break;
                case "0.10": ivaAcumulado[1] += precio*cantidad; break;
                case "0.21": ivaAcumulado[2] += precio*cantidad; break;
            }
            
            precioAcumulado += precio*cantidad*(1+iva);
            //Crear factura
            sb.append("\n").append(String.format("%-30s",p[0]));
            if(cantidad==1)
                sb.append(String.format("%10.2f",precio*(1+iva)));
            else
                sb.append("\n").append(String.format("%14d X %-13.2f%10.2f",cantidad,precio*(1+iva),precio*cantidad*(1+iva)));
        }
        
        sb.append("\n").append(String.format("%40s"," ").replace(" ","="))
        .append("\n").append(String.format("%-30s%10.2f","TOTAL A PAGAR",precioAcumulado))
        .append("\n").append(String.format("%40s"," ").replace(" ","="))
        .append("\n").append("DESGLOSES DEL IVA")
        .append("\n\n").append(String.format("%-12s%-12s%-12s","TIPO IVA","BASE","CUOTA"))
        .append("\n").append(String.format("%-12s%-12.2f%-12.2f","4.00%",ivaAcumulado[0],ivaAcumulado[0]*0.04))
        .append("\n").append(String.format("%-12s%-12.2f%-12.2f","10.00%",ivaAcumulado[1],ivaAcumulado[1]*0.1))
        .append("\n").append(String.format("%-12s%-12.2f%-12.2f","21.00%",ivaAcumulado[2],ivaAcumulado[2]*0.21));
        
        return sb.toString();
    }
}
