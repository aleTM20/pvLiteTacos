/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dell
 */
public class Tickets {

    private int idTicket;
    private String date;
    private float amount;
    private String seller;
    private String table;
    private int status;
    private String hour;
    private float effective;

    public Tickets(int idTicket, String date, float amount, String seller, String table, int status, String hour, float effective) {
        this.idTicket = idTicket;
        this.date = date;
        this.amount = amount;
        this.seller = seller;
        this.table = table;
        this.status = status;
        this.hour = hour;
        this.effective = effective;
    }


    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public float getEffective() {
        return effective;
    }

    public void setEffective(float effective) {
        this.effective = effective;
    }

}
