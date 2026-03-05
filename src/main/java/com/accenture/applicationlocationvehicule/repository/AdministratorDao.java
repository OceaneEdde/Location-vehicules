package com.accenture.applicationlocationvehicule.repository;


import com.accenture.applicationlocationvehicule.model.Administrator;
import com.accenture.applicationlocationvehicule.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorDao extends JpaRepository<Administrator, Integer> {
}