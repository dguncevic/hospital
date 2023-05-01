/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.beans;

import lombok.Data;

/**
 *
 * @author 19par
 */

public class Zupanije {
    
    private int id;
    private String nazivzupanije;
    private int pozivni;
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazivzupanije() {
        return nazivzupanije;
    }

    public void setNazivzupanije(String nazivzupanije) {
        this.nazivzupanije = nazivzupanije;
    }

    public int getPozivni() {
        return pozivni;
    }

    public void setPozivni(int pozivni) {
        this.pozivni = pozivni;
    }
    
    
    
    @Override
    public String toString(){
        return nazivzupanije;
    }
    
}
