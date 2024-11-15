package com.example.ticketingsystem.controller;

import com.example.ticketingsystem.entity.Configuration;
import com.example.ticketingsystem.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/config")
public class ConfigurationController {
    @Autowired
    private ConfigurationService configurationService;
    @PostMapping("/init")
    public Configuration iniitConfig(@RequestBody Configuration config){
        return configurationService.saveConfiguration(config);
    }
    @GetMapping
    public Configuration getConfig(){
        return configurationService.getConfiguration();
    }
}
