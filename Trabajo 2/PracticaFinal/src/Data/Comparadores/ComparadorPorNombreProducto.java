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

package Data.Comparadores;

import Data.Producto;
import java.util.Comparator;

/**
 *Realiza una comparacion por ID (nombre), de 2 Productos.
 * @see Data.Producto
 * @see java.util.Comparator
 * @author franp
 */
public class ComparadorPorNombreProducto implements Comparator<Producto>{
    @Override
    public int compare(Producto o1, Producto o2) {
        return o1.getNombre().compareToIgnoreCase(o2.getNombre());
    }   
}