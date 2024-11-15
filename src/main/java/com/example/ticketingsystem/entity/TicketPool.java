package com.example.ticketingsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TicketPool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int totalTickets;
    private int currentTickets;

    public TicketPool() {}

    public TicketPool(int totalTickets) {
        this.totalTickets = totalTickets;
        this.currentTickets = totalTickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getCurrentTickets() {
        return currentTickets;
    }

    public void setCurrentTickets(int currentTickets) {
        this.currentTickets = currentTickets;
    }
}
