package com.accenture.applicationlocationvehicule.model;

import com.accenture.applicationlocationvehicule.model.enums.LicensesListe;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Client extends UserLoggin{
    private String address;
    private LocalDateTime birthdate;
    private LocalDateTime inscriptiondate;

    @Enumerated(EnumType.STRING)
    private LicensesListe licensesListe;

    private Boolean desactive;


}
