/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Data;
import java.util.Random;

/**
 *
 * @author franp
 */
public class Controller {

    private final Data m = new Data();
    
    
    public void generateRandomData() {
       Random r = new Random();
       int[][]table = new int[6][31];
       
       for(int i=0; i<table.length; i++){
           for(int j=0; j<table[i].length; j++)
               table[i][j] = r.nextInt(100);
       }
       
       m.saveTable(table);
    }

    public int[][] getTableData() {
        return m.getTable();
    }

    public void editValue(int fil, int col, int value) {
        m.getTable()[fil][col] = value;
    }
    
}
