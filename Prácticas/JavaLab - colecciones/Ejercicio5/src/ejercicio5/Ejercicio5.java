/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author franp
 */
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ruta = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "El Quijote.txt";
                
        parte1(args);
        //parte2(ruta);
        //parte3(ruta);
    }
    
    
    public static void parte1(String[]args){
        List<String>lista = null;
        Map<String,Integer>mapa = null;
        
        lista = Arrays.asList(args);
        mapa  = frecuencias(lista);
        
        System.out.println("Palabras: " + lista.toString());
        System.out.println("Numero palabras sin repetir: " + mapa.keySet().size());
        
        System.out.println("Palabras sin repetir\n" + lista);
        System.out.println("Palabras sin repetir\n" + mapa.toString());
    }
    
    public static void parte2(String ruta){
        List<String> lista = null;
        Set<String>conjunto = null;
        
        lista = readFile(ruta);
        parseFile(lista);
        
        conjunto = new HashSet(lista);
        System.out.println("HASHSET:\t" + conjunto.toString());
        conjunto = new LinkedHashSet(lista);
        System.out.println("LINKEDASHSET:\t" + conjunto.toString());
        conjunto = new TreeSet(lista);
        System.out.println("TREESET:\t" + conjunto.toString());
    }

    public static void parte3(String ruta){
        List<String>lista = null;
        Map<String,Integer>mapa = null;
        
        lista = readFile(ruta);
        mapa = frecuencias(lista);
        System.out.println("Palabras sin repetir\n" + mapa.toString());
    } 
    
    
    
        public static Map<String,Integer> frecuencias(List<String>lista){
            Map<String,Integer>mapa = new HashMap();
            Map<String,Integer>resultado = null;
            
            for(String s : lista){
                if(mapa.containsKey(s))
                    mapa.replace(s, mapa.get(s) + 1);
                else
                    mapa.put(s,1);
            }

            resultado = new TreeMap(new comparadorValores(mapa));
            resultado.putAll(mapa);
            
            return resultado;
        }
    
        public static List<String> readFile(String ruta){
            File f = new File(ruta);
            List<String>lista = null;
            
            try{
                lista = Files.readAllLines(f.toPath(),Charset.defaultCharset());
            }catch(IOException e){
                System.err.println("ERROR: No se pudo leer " + ruta);
            }
           
            return lista;
        }
    
        public static void parseFile(List<String>lista){
            ListIterator<String> it = (ListIterator<String>) lista.iterator();
            String temp;
            while(it.hasNext()){
                temp = it.next();
                it.set(temp.split("\\*")[0]);
            }
        }
    
    
}
