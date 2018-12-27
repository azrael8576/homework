package com.train;

/**
 * Created by AlexHe on 2018-12-27.
 * Describe
 */

public class Ticket {
    private int single;
    private int total;
    private int roundTrip;

    public int getSingle() {
        return single;
    }
    public int getTotal() {
        return total;
    }
    public int getRoundTrip() {
        return roundTrip;
    }

    public Ticket(int total, int roundTrip) {
        single = total - roundTrip;
        this.total = total;
        this.roundTrip = roundTrip;
    }

    public double totalAmout (){
        return single * 1000 + roundTrip * 0.9 * 2000;
    }
}
