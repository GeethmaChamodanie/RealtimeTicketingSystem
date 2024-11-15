package com.example.ticketingsystem.service;

import com.example.ticketingsystem.entity.TicketPool;
import com.example.ticketingsystem.repository.TicketPoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantLock;

@Service
public class TicketPoolService {
    @Autowired
    private TicketPoolRepository ticketPoolRepository;

    private final ReentrantLock lock = new ReentrantLock();

    public TicketPool getTicketPoolStatus() {
        return ticketPoolRepository.findById(1L).orElseThrow(() -> new RuntimeException("Ticket Pool not found"));
    }

    public boolean buyTicket(Long customerId) {
        lock.lock();
        try {
            TicketPool ticketPool = ticketPoolRepository.findById(1L).orElseThrow(() -> new RuntimeException("Ticket Pool not found"));
            if (ticketPool.getCurrentTickets() > 0) {
                ticketPool.setCurrentTickets(ticketPool.getCurrentTickets() - 1);
                ticketPoolRepository.save(ticketPool);
                return true;
            } else {
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean addTickets(int ticketCount) {
        lock.lock();
        try {
            TicketPool ticketPool = ticketPoolRepository.findById(1L).orElseThrow(() -> new RuntimeException("Ticket Pool not found"));
            ticketPool.setCurrentTickets(ticketPool.getCurrentTickets() + ticketCount);
            ticketPoolRepository.save(ticketPool);
            return true;
        } finally {
            lock.unlock();
        }
    }
}
