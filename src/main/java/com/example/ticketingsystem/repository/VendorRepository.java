package com.example.ticketingsystem.repository;

import com.example.ticketingsystem.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
