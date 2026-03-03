package com.accenture.applicationlocationvehicule.repository;

import com.accenture.applicationlocationvehicule.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeDao extends JpaRepository<Bike, Integer> {
}
