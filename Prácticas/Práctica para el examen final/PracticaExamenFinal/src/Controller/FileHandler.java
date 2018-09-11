/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Paciente;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franp
 */
public class FileHandler {

    public void exportAsHtml(String ruta, List<String> datos, String titulo, String cabecera) throws IOException{
        List<String>lista = new ArrayList<>();
        lista.add("<!DOCTYPE html>\n<HTML>\n<HEAD><meta charset=\"UTF-8\"><H1>" + titulo + "</H1></HEAD>\n<BODY>\n<TABLE BORDER = 1>");
        lista.add(cabecera);
        lista.addAll(datos);
        lista.add("</TABLE>\n</BODY>\n</HTML>");
        writeTextFile(ruta,lista);
    }
    public void exportAsCsv(String ruta, List<String> lista) throws IOException{
        writeTextFile(ruta,lista);
    }
    public void exportAsTxt(String ruta, List<String> lista) throws IOException{
        writeTextFile(ruta,lista);
    }
    public String[][] parseTxt(List<String>txt){
        String[][]datos = new String[txt.size()][4];
        int i = 0;
        for(String s : txt)
            datos[i++] = s.split("\\*");
        return datos;
    }
    private void writeTextFile(String ruta, List<String>lista)throws IOException{
        File f = new File(ruta);
        Files.write(f.toPath(),lista);
    }
    public List<String> imporTxtData(String ruta)throws IOException{
        File f = new File(ruta);
        return Files.readAllLines(f.toPath());
    }
    
    public void saveBinary(String ruta, List<Paciente> lista) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(ruta))));
        oos.writeObject(lista);
        oos.close();
    }
    public List<Paciente> loadBinary(String ruta) throws IOException{
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(ruta))));
        List<Paciente>lista;
        try {
            lista = (List<Paciente>) ois.readObject();
        } catch (ClassNotFoundException ex) {
            throw new IOException();
        }
        ois.close();
        return lista;
    }
    
    public boolean exists(String ruta){
        File f = new File(ruta);
        return Files.exists(f.toPath());
    }
    



}
