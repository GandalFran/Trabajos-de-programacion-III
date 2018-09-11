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

package Otros;

import java.io.File;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author franp
 * Clase sobre constantes
 */
public class Constantes {
    
    public final static String RUTA_ESCRITORIO = System.getProperty("user.home") + File.separator + "Desktop";
    public final static String RUTA_SUPER_17 = RUTA_ESCRITORIO + File.separator + "Super17";
        
        public final static String RUTA_CLIENTES_BIN = RUTA_SUPER_17 + File.separator + "clientes.bin";
        public final static String RUTA_CLIENTES_CSV = RUTA_SUPER_17 + File.separator + "clientes.csv";
        
        public final static String RUTA_PRODUCTOS_BIN = RUTA_SUPER_17 + File.separator + "productos.bin";
        public final static String RUTA_PRODUCTOS_COL = RUTA_SUPER_17 + File.separator + "productos.col";
        public final static String RUTA_PRODUCTOS_CSV = RUTA_SUPER_17 + File.separator + "productos.csv";
        public final static String RUTA_PRODUCTOS_HTML = RUTA_SUPER_17 + File.separator + "productos.html";

        
    public final static String FORMATO_PRODUCTOS  = "|%-30s|%10.2f|%10.2f|%10d|";
    public final static String FORMATO_PRODUCTOS_TABLAS  = "|%-30s|%10s|%10s|%10s|";
    public final static String FORMATO_PRODUCTOS_ENCOLUMNADO  = "%-30s%10.2f%10.2f%10d";
    public final static String FORMATO_CLIENTES = "|%10s|%-20s, %-25s|%-40s|%10s|";
    public final static String FORMATO_CLIENTES_TABLAS = "|%10s|%-47s|%-40s|%10s|";
    
                                               
    public final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-M-uu HH:mm");
    
    public static int lastTicketId = 1;
    public static int lastFacuraId = 1;
}
