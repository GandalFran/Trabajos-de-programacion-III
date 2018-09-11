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

package Data;

import Otros.Constantes;
import java.util.Arrays;

/**
 *Informacion sobre una factura : id, total, fecha y DNI de cliente. Hereda de Ticket.
 * @see Data.Ticket
 * @author franp
 */
public class Factura extends Ticket{
    private String dniCliente;
    
    public Factura(String dniCliente, float total) {
        super(total);
        this.dniCliente = dniCliente;
    }
    public Factura(String idFactura){
        super(idFactura);
    }
    
    @Override
    protected String generateId(){
        return String.format("%08d",Constantes.lastFacuraId++);
    }

    /**
     * Devuelve informacion sobre una factura
     * @return String[] con la siguiente informacion f[0] id, f[1] total, f[2] fecha de emision y f[3] dniCliente
     * @see Data.Ticket toStringArray
     */
    @Override
    public String[]toStringArray(){
        String[]data = Arrays.copyOf(super.toStringArray(), 4);
        data[3] = this.dniCliente;
        return data;
    }

    public String getDniCliente() {
        return dniCliente;
    }
}
