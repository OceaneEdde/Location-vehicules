package com.accenture.applicationlocationvehicule.repository;


import com.accenture.applicationlocationvehicule.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, Integer> {
}