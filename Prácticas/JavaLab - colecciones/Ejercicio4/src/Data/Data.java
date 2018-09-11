/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author franp
 */
public class Data {
    private int[][]table;
    
    public Data(){
        this.table = new int[6][31];
    }
    
    public void saveTable(int[][] table) {
        this.table = table;
    }

    public int[][] getTable() {
        return this.table;
    }
    
}
