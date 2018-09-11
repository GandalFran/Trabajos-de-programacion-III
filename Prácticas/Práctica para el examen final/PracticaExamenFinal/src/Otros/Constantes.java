/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;

import java.io.File;

/**
 *
 * @author franp
 */
public interface Constantes {
    
    public static String RUTA_PACIENTES_HTML = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Hospital18" + File.separator + "pacientes.html";
    public static String RUTA_PACIENTES_CSV = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Hospital18" + File.separator + "pacientes.csv";
    public static String RUTA_PACIENTES_BIN = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Hospital18" + File.separator + "pacientes.bin";
    public static String RUTA_PACIENTES_TXT = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Hospital18" + File.separator + "pacientes.txt";
    public static String HTML_TITLE = "Pacientes";
    public static String HTML_HEADER = "<TR><TD><STRONG>DNI</STRONG></TD><TD><STRONG>Apellido 1</STRONG></TD><TD><STRONG>Apellido 2</STRONG></TD><TD><STRONG>Nombre</STRONG></TD></TR>";

}
