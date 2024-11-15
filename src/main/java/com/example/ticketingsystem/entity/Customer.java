package com.example.ticketingsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int retrievalInterval;
    public Customer() {}

    public Customer(String name, int retrievalInterval) {
        this.name = name;
        this.retrievalInterval = retrievalInterval;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRetrievalInterval() {
        return retrievalInterval;
    }

    public void setRetrievalInterval(int retrievalInterval) {
        this.retrievalInterval = retrievalInterval;
    }
}
