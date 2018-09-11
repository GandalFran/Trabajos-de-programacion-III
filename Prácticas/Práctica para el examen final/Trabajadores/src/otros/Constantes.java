/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otros;

import java.io.File;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author franp
 */
public interface Constantes {
    public static final DateTimeFormatter FORMATO_FECHAS = DateTimeFormatter.ofPattern("H:m d/M/y");
    public static final int NUM_TRABAJADORES = 20;
    public static final int[]DNIS = {111111111,22222222,333333333,444444444,555555555};
    public static final String[]NOMBRES = {"Fran","Pedro","Juan","Luis"};
    public static final String[]APELLIDOS = {"Perez","Jimenez","Pinto","Blazquez"};
    public static final int MAX_SALARIO = 2000;
    
    public static String RUTA_HTML = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "trabajadores.html";
    public static String RUTA_CSV = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "trabajadores.csv";
    public static String RUTA_BIN = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "trabajadores.bin";
    
    public static String TITULO_HTML = "TRABAJADORES";
    public static String HEADER_HTML = "<TR><TD></STRONG>DNI</STRONG></TD><TD></STRONG>APELLIDOS</STRONG></TD><TD></STRONG>NOMBRE</STRONG></TD><TD></STRONG>SALARIO</STRONG></TD><TD></STRONG>CONTRATO</STRONG></TD></TR>";
}
