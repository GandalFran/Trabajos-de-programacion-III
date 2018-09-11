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
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *Informacion sobre un ticket: id, total y fecha.
 * @author franp
 */
public class Ticket implements Serializable{
    protected String id;
    protected float total;
    protected LocalDateTime fecha;
    
    public Ticket(float total) {
        this.id = generateId();
        this.total = total;
        this.fecha = LocalDateTime.now();
    }
    public Ticket(String idTicket) {
        this.id = idTicket;
        this.total = 0;
        this.fecha = LocalDateTime.now();
    }
    
    protected String generateId(){
        return String.format("%08d",Constantes.lastTicketId++);
    }

    /**
     * Devuelve informacion sobre un ticket
     * @return String[] con la siguiente informacion f[0] id, f[1] total y f[2] fecha de emision
     */
    public String[]toStringArray(){
        String[]data = new String[3];
        
        data[0] = String.valueOf(this.id);
        data[1] = String.valueOf(this.total);
        data[2] = this.fecha.format(Constantes.DATE_FORMATTER);
        return data;
    }
    
    public String getId() {
        return id;
    }
    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    
}
