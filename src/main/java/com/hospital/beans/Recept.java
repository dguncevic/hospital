/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.beans;

import java.sql.Date;


class Recept {

    private int id;
    private int lijekid;
    private int korisnikid;
    private Date datumOd;
    private Date datumDo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLijekid() {
        return lijekid;
    }

    public void setLijekid(int lijekid) {
        this.lijekid = lijekid;
    }

    public int getKorisnikid() {
        return korisnikid;
    }

    public void setKorisnikid(int korisnikid) {
        this.korisnikid = korisnikid;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

}
