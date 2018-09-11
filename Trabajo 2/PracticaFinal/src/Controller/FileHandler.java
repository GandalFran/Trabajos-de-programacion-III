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

package Controller;

import Data.Cliente;
import Data.Producto;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

/**
 *Clase para gestion de ficheros que incluye E/S de ficheros de texto y binarios; ademas del tratamiendo de la informacion leida de estos.
 * @author franp
 */
public class FileHandler {
    /**
     * Lectura de fichero de texto
     * @param ruta ruta del fichero a leer
     * @return devuelve null si fracasa o una lista de Strings con el texto del archivo si tiene exito
     * @throws java.io.IOException Si no consigue importar los datos.
     */
    public List<String>importFromTextFile(String ruta) throws IOException{
       File f = new File(ruta);
        
       List<String>lines = null;
        if(Files.exists(f.toPath()))
            lines = Files.readAllLines(f.toPath(),Charset.forName("UTF-8"));
       
       return lines;
    }
    
    /**
     * Escritura de fichero de texto
     * @param ruta ruta del fichero a escribir
     * @param aEscribir lista de Strings para escribir en el fichero
     * @throws java.io.IOException Si no consigue exportar los datos.
     */
    public void exportToTextFile(String ruta, List<String>aEscribir) throws IOException{
        File f = new File(ruta);
        Files.write(f.toPath(),aEscribir,Charset.forName("UTF-8"));
    }
    
    /**
     * Lectura de fichero binario
     * @param ruta ruta del fichero a leer
     * @return devuelve null si fracasa o unos datos con el texto del archivo si tiene exito
     * @throws java.io.IOException Si no consigue importar los datos.
     */
    public List<Producto> loadBinaryFileProducto(String ruta) throws IOException{
        List<Producto>lista = null;
        File f = new File(ruta);
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream( new FileInputStream(f)));
        
        try {
            lista = (List<Producto>) ois.readObject();
        } catch (ClassNotFoundException ex) {
            throw new IOException();
        }
        ois.close();

        return lista;
    }
    /**
     * Lectura de fichero binario
     * @param ruta ruta del fichero a leer
     * @return devuelve null si fracasa o unos datos con el texto del archivo si tiene exito
     * @throws java.io.IOException Si no consigue importar los datos.
     */
    public List<Cliente> loadBinaryFileCliente(String ruta) throws IOException{
        List<Cliente>lista = null;
        File f = new File(ruta);
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream( new FileInputStream(f)));
        
        try {
            lista = (List<Cliente>) ois.readObject();
        } catch (ClassNotFoundException ex) {
            throw new IOException();
        }
        ois.close();
        
        return lista;
    }
    /**
     * Escritura de fichero binario de productos.
     * @param ruta ruta del fichero a escribir
     * @param aEscribir productos a escribir en el fichero
     * @throws java.io.IOException Si no consigue exportar los datos.
     */
    public void writeBinaryFileProducto(String ruta,List<Producto>aEscribir) throws IOException{
        File f = new File(ruta);
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
        oos.writeObject(aEscribir);
        oos.close();
    }
    /**
     * Escritura de fichero binario de clientes.
     * @param ruta ruta del fichero a escribir
     * @param aEscribir clientes a escribir en el fichero
     * @throws java.io.IOException Si no consigue exportar los datos.
     */
    public void writeBinaryFileCliente(String ruta,List<Cliente>aEscribir) throws IOException{
        File f = new File(ruta);
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
        oos.writeObject(aEscribir);
        oos.close();
    }
    
    /**
     * Dice si existe o no un fichero
     * @param ruta ruta del fichero del cual se quiere saber si existe
     * @return devuelve true si existe y false en caso contrario.
     */
    public boolean exists(String ruta){
        File f = new File(ruta);
        return Files.exists(f.toPath());
    }

    /**
     * Separa los datos leidos de un archivo csv
     * @param leido datos a separar en csv
     * @param separador caracter que separa los datos en una linea
     * @return devuelve una matriz de datos separados donde cada fila se corresponde con una Strin de "leido"
     */
    public String[][] parseCsv(List<String>leido,String separador) {
        String[][]tratado = new String[leido.size()][0];
        int i = 0;
        for(String s: leido){
            tratado[i] = s.split(separador);
            for(int j=0; j<tratado[i].length; j++) tratado[i][j] = tratado[i][j].trim();   //por si quedan espacios que no haya error    
            i++;
        }
        return tratado;
    }

    /**
     * Genera la cabecera y el cierre de un archivo html sobre lista
     * @param lista lista de datos sobre la que se realiza el envoltorio de html
     * @param titulo titulo que queremos que aparezca en nuestro archivo html
     */
    public void generarEnvoltorioHtml(List<String> lista,String titulo) {
        lista.add(0,String.format("<!DOCTYPE html>\n<HTML>\n<HEAD><meta charset=\"UTF-8\"><H1>%s</H1></HEAD>\n<BODY>",titulo));
        lista.add(0,"<TABLE BORDER = 1>");
        lista.add("</TABLE>\n</BODY>\n</HTML>");
    }
}
