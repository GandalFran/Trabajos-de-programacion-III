/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.Trabajador;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import otros.Constantes;

/**
 *
 * @author franp
 */
class FileHandler {

    public void exportHtml(List<String> htmlData) throws IOException{
        List<String>aEscribir = new ArrayList<>();
        aEscribir.add("<!DOCTYPE HTML>\n<HTML>\n<HEAD> <meta charset = \"UTF-8\"> <H1>" + Constantes.TITULO_HTML + "</H1></HEAD>\n<BODY>\n<TABLE BORDER = 1>");
        aEscribir.addAll(htmlData);
        aEscribir.add("</TABLE>\n</BODY>\n</HTML>");
        
        File f = new File(Constantes.RUTA_HTML);
        Files.write(f.toPath(),aEscribir);
    }

    public void exportCsv(List<String> csvData) throws IOException{
        File f = new File(Constantes.RUTA_CSV);
        Files.write(f.toPath(),csvData);
    }

    public void exportBinary(List<Trabajador> trabajadores) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(Constantes.RUTA_BIN))));
        oos.writeObject(trabajadores);
        oos.close();
    }
    
}
