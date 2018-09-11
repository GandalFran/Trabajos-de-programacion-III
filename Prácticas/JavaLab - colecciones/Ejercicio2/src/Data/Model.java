package Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author franp
 */
public class Model {

    private List<HardDisk>hds;
    
    public Model(){
        this.hds = new ArrayList<>();
    }
    
    public String[][] getAllHdds() {
        String[][]data = new String[this.hds.size()][0];
        if( null==this.hds || this.hds.isEmpty()) return null;

        int i = 0;
        for(HardDisk h : this.hds)
            data[i++] = h.toStringArray();
        
        return data;
    }
    
    public void sortHds(){
        Collections.sort(hds);
    }

    public void generateRandomHdds(int nHDDs) {
        for(int i=0; i<nHDDs; i++)
            this.hds.add(HardDisk.generateRandomValues());
    }

    public List<HardDisk> getHds() {
        return hds;
    }
    public void setHds(List<HardDisk> hds) {
        this.hds = hds;
    }
    
    
    
}
