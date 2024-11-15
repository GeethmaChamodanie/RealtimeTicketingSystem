package com.example.ticketingsystem.controller;

import com.example.ticketingsystem.entity.TicketPool;
import com.example.ticketingsystem.service.TicketPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketPoolController {
    @Autowired
    private TicketPoolService ticketPoolService;

    @GetMapping("/status")
    public TicketPool getTicketPoolStatus() {
        return ticketPoolService.getTicketPoolStatus();
    }

    @PostMapping("/buy")
    public boolean buyTicket(@RequestParam Long customerId) {
        return ticketPoolService.buyTicket(customerId);
    }

    @PostMapping("/add")
    public boolean addTickets(@RequestParam int ticketCount) {
        return ticketPoolService.addTickets(ticketCount);
    }
}
