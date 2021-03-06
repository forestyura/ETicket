package com.ksvteam.controller;

import com.ksvteam.entity.Ticket;
import com.ksvteam.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Yuriy Vlasiuk on 19.03.2017.
 */

@RestController
public class TicketController {
    private TicketService ticketService = TicketService.getInstance();

    @RequestMapping(value = "/addTicket", method = RequestMethod.POST)
    public long addTicket(@RequestBody Ticket ticket) {
        ticket.setExpiryDate(new Date(ticket.getExpiryDate().getTime() + 2592000000L));
        return ticketService.addTicket(ticket);
    }


    @RequestMapping(value = "/addTicketParam", method = RequestMethod.POST)
    public long addTicketParam(@RequestParam long routeID, @RequestParam int numberOfTrips, @RequestParam long expiryDate) {
        Ticket ticket = new Ticket();
        ticket.setExpiryDate(new Date(expiryDate + 2592000000L));
        ticket.setRouteID(routeID);
        ticket.setNumberOfTrips(numberOfTrips);
        return ticketService.addTicket(ticket);
    }


    @RequestMapping(value = "/checkTicket", method = RequestMethod.POST)
    public ResponseEntity checkTicket(@RequestParam long ticketID, @RequestParam long routeID) {

        Ticket ticket;
        try {
            ticket = ticketService.getTicket(ticketID);
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Ticket not found");
        }

        if (ticket.getExpiryDate().getTime() < new Date().getTime()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Ticket Expired");
        }
        if (ticket.getRouteID() != routeID) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("The ticket does not fit");
        }

        if(ticket.getNumberOfTrips() < 1) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("The trips ended");
        }

        ticket.setNumberOfTrips(ticket.getNumberOfTrips() - 1);
        ticketService.editTicket(ticket);
        return ResponseEntity.ok("Ticket ok");

    }

    @RequestMapping(value = "/getAllTicket", method = RequestMethod.GET)
    public ArrayList<Ticket> getAllTicket() {
        return ticketService.getAllTicket();
    }
}
