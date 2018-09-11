/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;

import java.io.File;

/**
 *
 * @author franp
 */
public interface Constantes {
    
    public static final String[]FABRICANTES = {"Samsung","Coti","Aperture Science","Angelica","Apple"};
    public static final String[]MODELOS = {"istari","gandalf","radagast","saruman","azules"};
    public static final String[]TIPOS_INTERFACE= {"Pene","Sida","Rick es el puto amo","Gandalf rules"};
    public static final String[]TECNOLOGIAS = {"HDD","SSD"};
    public static final int MAX_MB = 100;
    public static final int MAX_TASA_TRANSMISION = 100;
    public static final int MAX_VELOCIDAD_ROTACION = 50;
    
    public static final int NUM_RANDOM_HDDS = 20;
    public static final String HDD_FORMAT = "|%-20s|%10s|%-20s|%-20s|%15s|%20s|%20s|%10s|";
    public static final String RUTA_FICHERO = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "hdds.bin";
}
