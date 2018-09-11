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

package Data;

import Otros.Constantes;
import java.io.Serializable;
/**
 *Informacion sobre un producto: nombre, stock, precio e iva.
 * @author franp
 */
public class Producto implements Serializable{
    private String nombre;
    private int stock;
    private float precio;
    private float iva;

    public Producto(String nombre, int stock, float precio, float iva) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.iva = iva;
    }
    public Producto(String idProducto) {
        this.nombre = idProducto;
        this.stock = 0;
        this.precio = 0;
        this.iva = 0f;
    }
    
    /**
     * Rellena un producto con los datos contenidos en data
     * @param data datos de un producto en el formato definido en Data.Producto.toStringArray
     * @see Data.Producto toStringArray
     * @return Producto con los datos de data
     */
    public static Producto fillProducto(String[]data) throws NumberFormatException{
        Producto p = new Producto(data[0]);
        
        p.precio = Float.parseFloat(data[1]);
        p.iva = Float.parseFloat(data[2]);
        p.stock = Integer.parseInt(data[3]);
        
        return p;
    }
    
    /**
     * Devuelve informacion sobre el producto en forma de array de String
     * @return f[0] nombre, f[1] precio, f[2] iva y f[3] stock
     */
    public String[]toStringArray(){
        String[]data = new String[4];
        data[0] = this.nombre;
        data[1] = String.valueOf(this.precio);
        data[2] = String.valueOf(this.iva);
        data[3] = String.valueOf(this.stock);
        return data;
    }
    /**
     * Devuelve la informacion de un producto en formato encolumnado
     * @return informacion de un producto en formato encolumnado
     */
    public String toFormatedString() {
        return String.format(Constantes.FORMATO_PRODUCTOS_ENCOLUMNADO,this.nombre,this.precio,this.iva,this.stock);
    }
    /**
     * Devuelve la informacion de un producto en formato html
     * @return informacion de un producto en formato html
     */
    public String toHtmlString() {
        return String.format("<TR><TD>%s</TD><TD>%.2f</TD><TD>%.2f</TD><TD>%d</TD></TR>",this.nombre,this.precio,this.iva,this.stock);
    }
    
    

    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public float getIva() {
        return iva;
    }
    public void setIva(float iva) {
        this.iva = iva;
    }

}
