/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.*;

/**
 *
 * @author leokk
 */
public class Records {
    private Map<Integer, SingleRecord> map;

    protected Records(Map<Integer, SingleRecord> map) {
        this.map = map;
    }

    protected Records() {
        map = new HashMap<>();
    }

    protected Map getMap() {
        return map;
    }

    protected void setMap(Map<Integer, SingleRecord> map) {
        this.map = map;
    }
    
    protected void put(SingleRecord record) {
        this.map.put(hashCode(), record);
    }
    
    protected SingleRecord get(Integer keyInteger){
        return this.map.get(keyInteger);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.map);
        return hash;
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
        final Records other = (Records) obj;
        return Objects.equals(this.map, other.map);
    }
    
    
    
}
