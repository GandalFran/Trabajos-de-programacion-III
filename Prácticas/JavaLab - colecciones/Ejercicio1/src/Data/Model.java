package Data;

import java.util.ArrayList;
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

    private List<Bill>bills;
    
    public Model(){
        this.bills = new ArrayList<>();
    }
    
    public String[][] getAllBills() {
        String[][]data = new String[bills.size()][0];
        if( null==bills || bills.isEmpty()) return null;

        int i = 0;
        for(Bill b : this.bills)
            data[i++] = b.toStringArray();
        
        return data;
    }

    public void generateRandomBills(int nBills) {
        for(int i=0; i<nBills; i++)
            this.bills.add(Bill.generateRandomValues());
    }
    
}
