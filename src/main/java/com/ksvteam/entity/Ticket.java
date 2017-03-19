package com.ksvteam.entity;

import java.util.Date;

/**
 * Created by Yuriy Vlasiuk on 19.03.2017.
 */
public class Ticket {
    private long ticketID;
    private long routeID;
    private int numberOfTrips;
    private Date expiryDate;

    public Ticket(long ticketID, long routeID, int numberOfTrips, Date expiryDate) {
        this.ticketID = ticketID;
        this.routeID = routeID;
        this.numberOfTrips = numberOfTrips;
        this.expiryDate = expiryDate;
    }

    public Ticket() {
    }

    public long getTicketID() {
        return ticketID;
    }

    public void setTicketID(long ticketID) {
        this.ticketID = ticketID;
    }

    public long getRouteID() {
        return routeID;
    }

    public void setRouteID(long routeID) {
        this.routeID = routeID;
    }

    public int getNumberOfTrips() {
        return numberOfTrips;
    }

    public void setNumberOfTrips(int numberOfTrips) {
        this.numberOfTrips = numberOfTrips;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
