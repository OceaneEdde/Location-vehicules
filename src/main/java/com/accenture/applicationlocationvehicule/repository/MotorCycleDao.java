package com.accenture.applicationlocationvehicule.repository;

import com.accenture.applicationlocationvehicule.model.MotorCycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorCycleDao extends JpaRepository<MotorCycle, Integer> {
}
