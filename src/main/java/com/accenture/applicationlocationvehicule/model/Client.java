package com.accenture.applicationlocationvehicule.model;

import com.accenture.applicationlocationvehicule.model.enums.LicensesListe;
import com.accenture.applicationlocationvehicule.model.enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Client extends UserLoggin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private Address address;

    private LocalDate birthdate;
    private LocalDate registrationdate;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<LicensesListe> licensesListeList = new ArrayList<>();

    private Boolean desactive;

    @Enumerated(EnumType.STRING)
    private Roles role;
}
