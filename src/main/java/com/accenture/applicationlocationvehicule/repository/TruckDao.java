package com.accenture.applicationlocationvehicule.repository;

import com.accenture.applicationlocationvehicule.model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckDao extends JpaRepository<Truck, Integer> {
}
