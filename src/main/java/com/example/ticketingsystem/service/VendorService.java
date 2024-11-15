package com.example.ticketingsystem.service;

import com.example.ticketingsystem.entity.Vendor;
import com.example.ticketingsystem.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;

    private final Lock lock = new ReentrantLock();

    public Vendor createVendor(Vendor vendor) {
        lock.lock();
        try {
            return vendorRepository.save(vendor);
        } finally {
            lock.unlock();
        }
    }

    public void simulateVendorAddingTickets(Vendor vendor) {
        while (true) {
            try {
                Thread.sleep(vendor.getReleaseInterval());
                // Simulate vendor adding tickets
                new TicketPoolService().addTickets(vendor.getTicketsPerRelease());
                System.out.println(vendor.getName() + " added " + vendor.getTicketsPerRelease() + " tickets!");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
