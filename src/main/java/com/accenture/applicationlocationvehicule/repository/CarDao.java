package com.accenture.applicationlocationvehicule.repository;

import com.accenture.applicationlocationvehicule.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDao extends JpaRepository<Car, Integer> {
}
