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


    public Client(int id, String firstname, String lastname, String email, String password, Roles roles, Address address, LocalDate birthdate, LocalDate registrationdate, List<LicensesListe> licensesListeList, Boolean desactive) {
        super(id, firstname, lastname, email, password, roles);
        this.address = address;
        this.birthdate = birthdate;
        this.registrationdate = registrationdate;
        this.licensesListeList = licensesListeList;
        this.desactive = desactive;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(id);
        sb.append(", address=").append(address);
        sb.append(", birthdate=").append(birthdate);
        sb.append(", registrationdate=").append(registrationdate);
        sb.append(", licensesListeList=").append(licensesListeList);
        sb.append(", desactive=").append(desactive);
        sb.append('}');
        return sb.toString();
    }
}
