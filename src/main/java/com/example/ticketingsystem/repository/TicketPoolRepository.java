package com.example.ticketingsystem.repository;


import com.example.ticketingsystem.entity.TicketPool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketPoolRepository extends JpaRepository<TicketPool, Long> {
}