package com.example.ticketingsystem.repository;

import com.example.ticketingsystem.entity.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration,Long> {
}
