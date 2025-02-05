package com.offers;

public class Offer {
    private int id;
    private String date;
    private String date2;
    private String offer;

    public Offer(int id, String date,String date2, String offer) {
        this.id = id;
        this.date = date;
        this.date2 = date2;
        this.offer = offer;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }
    
    public String getDate2() {
    	return date2;
    }

    public String getOffer() {
        return offer;
    }
}
