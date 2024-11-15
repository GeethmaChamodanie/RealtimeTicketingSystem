package com.example.ticketingsystem.service;

import com.example.ticketingsystem.entity.Customer;
import com.example.ticketingsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    private final Lock lock = new ReentrantLock();

    public Customer createCustomer(Customer customer) {
        lock.lock();
        try {
            return customerRepository.save(customer);
        } finally {
            lock.unlock();
        }
    }

    public void simulateCustomerBuyingTickets(Customer customer) {
        while (true) {
            try {
                Thread.sleep(customer.getRetrievalInterval());
                // Simulate ticket buying
                boolean ticketBought = new TicketPoolService().buyTicket(customer.getId());
                if (ticketBought) {
                    System.out.println(customer.getName() + " successfully bought a ticket!");
                } else {
                    System.out.println(customer.getName() + " failed to buy a ticket!");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
