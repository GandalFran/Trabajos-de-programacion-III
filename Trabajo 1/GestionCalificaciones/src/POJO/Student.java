/*
 * Copyright (C) 2017 Fran
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package POJO;

import java.util.Objects;

/**
 *
 * @author Fran
 */
public class Student {
    private String name;
    private float parcial1;
    private float parcial2;
    private float finalExam;
    
    
    public Student(String name, float parcial1, float parcial2, float finalExam){
        this.name=name;
        this.parcial1=parcial1;
        this.parcial2=parcial2;
        this.finalExam=finalExam;
    }
    public Student(){
    }
    
    @Override
    public String toString() {
        return "Alumno{" + "name=" + name + ", parcial1=" + parcial1 + ", parcial2=" + parcial2 + ", finalExam=" + finalExam + '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (Float.floatToIntBits(this.parcial1) != Float.floatToIntBits(other.parcial1)) {
            return false;
        }
        if (Float.floatToIntBits(this.parcial2) != Float.floatToIntBits(other.parcial2)) {
            return false;
        }
        if (Float.floatToIntBits(this.finalExam) != Float.floatToIntBits(other.finalExam)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }  
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getParcial1() {
        return parcial1;
    }
    public void setParcial1(float parcial1) {
        this.parcial1 = parcial1;
    }
    public float getParcial2() {
        return parcial2;
    }
    public void setParcial2(float parcial2) {
        this.parcial2 = parcial2;
    }
    public float getFinalExam() {
        return finalExam;
    }
    public void setFinalExam(float finalExam) {
        this.finalExam = finalExam;
    }
}
