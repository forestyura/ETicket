package com.ksvteam.service;

import com.ksvteam.entity.Ticket;

import java.util.HashMap;

/**
 * Created by Yuriy Vlasiuk on 19.03.2017.
 */
public class TicketService {
    private static TicketService instance;
    private HashMap<Long, Ticket> ticketHashMap;

    private TicketService() {
        ticketHashMap = new HashMap<>();
    }

    public static synchronized TicketService getInstance() {
        if (instance == null) {
            instance = new TicketService();
        }
        return instance;
    }

    public long addTicket(Ticket ticket){
        long ticketID = ticketHashMap.size() + 1;
        ticket.setTicketID(ticketID);
        ticketHashMap.put(ticket.getTicketID(), ticket);
        return ticketID;
    }

    public Ticket getTicket(long ticketID) throws Exception {
        Ticket ticket;
        if ((ticket = ticketHashMap.get(ticketID)) == null){
            throw new Exception("Ticket not found");
        }
        return ticket;
    }

    public void editTicket(Ticket ticket){
        ticketHashMap.put(ticket.getTicketID(), ticket);
    }
}
