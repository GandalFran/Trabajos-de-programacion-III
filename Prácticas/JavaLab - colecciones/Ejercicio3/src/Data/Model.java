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

    private List<Ficha>fichas;
    
    public Model(){
        this.fichas = new ArrayList<>();
    }
    
    public String[][] getAllFichas() {
        String[][]data = new String[this.fichas.size()][0];
        if( null==this.fichas || this.fichas.isEmpty()) return null;

        int i = 0;
        for(Ficha h : this.fichas)
            data[i++] = h.toStringArray();
        
        return data;
    }
    
    public void sortFichas(){
        Collections.sort(fichas);
    }

    public void generateRandomFichas(int nHDDs) {
        for(int i=0; i<nHDDs; i++)
            this.fichas.add(Ficha.generateRandomValues());
    }
    
}
