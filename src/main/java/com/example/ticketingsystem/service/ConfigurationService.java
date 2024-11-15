package com.example.ticketingsystem.service;

import com.example.ticketingsystem.entity.Configuration;
import com.example.ticketingsystem.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {
    @Autowired
    private ConfigurationRepository repository;

    public Configuration saveConfiguration(Configuration config){
        return repository.save(config);
    }
    public Configuration getConfiguration(){
        return repository.findById(1L).orElseThrow(()-> new RuntimeException("Configuration not set"));
    }
}
