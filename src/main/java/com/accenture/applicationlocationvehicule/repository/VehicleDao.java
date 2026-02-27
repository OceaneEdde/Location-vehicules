package com.accenture.applicationlocationvehicule.repository;

import com.accenture.applicationlocationvehicule.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDao extends JpaRepository<Vehicle, Integer> {
}
