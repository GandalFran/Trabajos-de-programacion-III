/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author franp
 */
public class comparadorValores implements Comparator<String>{

    
    HashMap<String, Integer> map = new HashMap<>();

    public comparadorValores(Map<String, Integer> map){
            this.map.putAll(map);
    }

    @Override
    public int compare(String s1, String s2) {
            if(map.get(s1) < map.get(s2)){
                    return -1;
            }else{
                    return 1;
            }	
    }
    
}
